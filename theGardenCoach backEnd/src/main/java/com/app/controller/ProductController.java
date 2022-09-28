package com.app.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.app.DTO.ProductDTO;
import com.app.DTO.ProductPageResponseDTO;
import com.app.DTO.ProductResponseDTO;
import com.app.DTO.Response;
import com.app.pojos.Product;
import com.app.pojos.Seller;
import com.app.service.IProductService;
import com.app.service.ISellerService;

@CrossOrigin
@RestController
@RequestMapping("/api/products")
public class ProductController 
{
	@Autowired
	private IProductService productService;
	@Autowired
	private ISellerService sellerService;
	
	
	@PostMapping
	public ResponseEntity<?> saveProduct(@RequestPart("product") ProductDTO productDto,@RequestPart("pic") MultipartFile pic) {
		System.out.println("in Controler"+productDto.toString());
//		Product product=ProductDTO.toProductEntity(productDto);
		Seller seller=sellerService.findById(productDto.getSellerId());
		System.out.println(productDto.toString());
		productDto.setSellerId(seller.getId());
		productService.addProduct(productDto,pic);
		System.out.println(productDto);
		return Response.success(productDto);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<?> updateProduct(@RequestBody Product product,@PathVariable("id") int id) {
		System.out.println(product);		
		productService.updateProduct(product);
		return Response.success(product);		
	}
	
	@GetMapping("{id}")
	public ResponseEntity<?> findProduct(@PathVariable("id")int id) {
		Product product=productService.findProductById(id);
		return Response.success(ProductResponseDTO.fromProductEntity(product));
	}
	
	@GetMapping
	public ResponseEntity<?> findAllProducts(Optional<Integer> sellerid) {
		List<ProductResponseDTO> result = new ArrayList<ProductResponseDTO>();
		if(sellerid.isPresent()) {
			System.out.println(sellerid);
			for(Product p : productService.findProducts(sellerid.get())) {
				result.add(ProductResponseDTO.fromProductEntity(p));
			}
			
		}else {
			for(Product p : productService.allProducts()) {
				result.add(ProductResponseDTO.fromProductEntity(p));
			}
		}
		
		return Response.success(result);
	}
	
	@GetMapping("/paginated")
	public ResponseEntity<?> paginatedProducts(int page,int pagesize) {
		List<ProductResponseDTO> result = new ArrayList<ProductResponseDTO>();
		Page<Product> data=productService.allProductsPaginated(page, pagesize);
		data.forEach(item-> {
			result.add(ProductResponseDTO.fromProductEntity(item));
		});
		ProductPageResponseDTO resp=new ProductPageResponseDTO();
		resp.setPagesize(pagesize);
		resp.setCurrent(page);
		resp.setTotal(data.getTotalElements());
		resp.setPlist(result);
		return Response.success(resp);
	}
	
	@GetMapping("cats")
	public ResponseEntity<?> findCategoryProducts(String cat,String subcat) {
		List<ProductResponseDTO> result = new ArrayList<ProductResponseDTO>();
		
		for(Product p : productService.categoryProducts(cat, subcat)) {
			result.add(ProductResponseDTO.fromProductEntity(p));
		}
		
		return Response.success(result);
	}
		
	
	@DeleteMapping("{id}")
	public ResponseEntity<?> deleteProduct(@PathVariable("id") int id) {
		productService.deleteProduct(id);
		return Response.status(HttpStatus.OK);
	}
	

}
