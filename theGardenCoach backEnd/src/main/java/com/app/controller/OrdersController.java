package com.app.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.DTO.CartDTO;
import com.app.DTO.OrderDetailsDTO;
import com.app.DTO.OrderResponseDTO;
import com.app.DTO.PlaceOrderDTO;
import com.app.DTO.Response;
import com.app.pojos.Address;
import com.app.pojos.Customer;
import com.app.pojos.Order;
import com.app.pojos.OrderDetails;
import com.app.pojos.Payment;
import com.app.pojos.Product;
import com.app.service.EmailService;
import com.app.service.IAddressService;
import com.app.service.ICustomerService;
import com.app.service.IOrderDetailService;
import com.app.service.IOrderService;
import com.app.service.IPaymentService;
import com.app.service.IProductService;

@CrossOrigin
@RestController
@RequestMapping("/api/orders")
public class OrdersController {

	@Autowired
	private IOrderService orderService;
	@Autowired
	private ICustomerService custService;
	@Autowired
	private IAddressService addressService;
	@Autowired
	private IPaymentService paymentService;
	@Autowired
	private IOrderDetailService orderDetailService;
	@Autowired
	private IProductService productService;
	@Autowired
	private EmailService emailService;
	
	
	@PostMapping
	public ResponseEntity<?> save(@RequestBody PlaceOrderDTO dto){
		Address address = addressService.saveAddress(dto.getAddress());
		dto.getPayment().setPaymentdate(new Date());
		Payment payment=paymentService.savePayment(dto.getPayment());
		Order order=new Order();
		order.setOrderDate(new Date());
		order.setAddress(address);
		order.setPayment(payment);
		Customer customer = custService.findById(dto.getCustomerid());
		order.setCustomer(customer);
		Order saveOrder=orderService.saveOrder(order);
		String sellerEmail="";
		String sellerName="";
		Product product=null;
		int qty=0;
		
		for(CartDTO cart : dto.getCart()) {
			OrderDetails od =  new OrderDetails();
			od.setOrder(saveOrder);
			od.setQty(cart.getQty());
			product=productService.findProductById(cart.getProdid());
			sellerEmail=product.getSeller().getEmail();
			sellerName=product.getSeller().getName();
			qty=cart.getQty();
			od.setProduct(product);
			orderDetailService.saveOrderDetails(od);
		}
		
		System.out.println(dto.getAddress());
		System.out.println(dto.getCustomerid());
		System.out.println(dto.getPayment());
		System.out.println(dto.getCart().get(0));
		
		System.out.println(sellerEmail+" "+sellerName+" "+qty);
		
		emailService.sendSimpleMessage(sellerEmail, "New Order Received", "Dear "+sellerName+",<br>You have been received new order from customer"+
		"<br>Product Name : "+product.getPname()+"<br>Product Quatity : "+qty+" Address : "+address);
		
		emailService.sendSimpleMessage(customer.getEmail(), "Your Order is successfully Received", "by "+sellerName+",<br>You have been received your order by 3 days"+
				"<br>Product Name : "+product.getPname()+"<br>Product Quatity : "+qty+" on Address : "+address);
		
		return Response.status(HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<?> findAllOrders(Optional<Integer> custid){
		List<Order> result = null;
		if(custid.isPresent()) {
			Customer customer = custService.findById(custid.get());
			result = orderService.getCustomerOrders(customer);
		}
		else {
			result = orderService.getAllOrders();
		}
		return Response.success(result);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> findOrderById(@PathVariable("id") int id){
		Order order= orderService.findById(id);
		List<OrderDetails> details = orderDetailService.findByOrder(order);
		List<OrderDetailsDTO> detailsDto=new ArrayList<OrderDetailsDTO>();
		details.forEach(od -> {
			OrderDetailsDTO dto = OrderDetailsDTO.fromEntity(od);
			detailsDto.add(dto);
		});
		
		OrderResponseDTO result = new OrderResponseDTO();
		result.setOrder(order);
		result.setDetails(detailsDto);
		return Response.success(result);
	}
}
