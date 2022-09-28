package com.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.app.DTO.ProductDTO;
import com.app.Dao.IProductDao;
import com.app.Utils.IStorageService;
import com.app.pojos.Product;

@Service
@Transactional
public class ProductServiceImpl implements IProductService {

	@Autowired
	private IProductDao pdao;
	
	@Autowired
	private ISellerService  sService;
	@Autowired
	 private IStorageService storageService;
	
	@Override
	public void addProduct(ProductDTO p, MultipartFile pic) 
	{
//		try
//		{
//			System.out.println(p.toString()+" "+getClass());
//		String photo=storageService.store(pic);
//		System.out.println(photo.toString());
//		p.setPhoto(photo);
//		pdao.save(p);
//		System.out.println(p.getPhoto());
//		}
//		catch(Exception ex) {
//			System.out.println(ex.getMessage());
//		}
		
		
		System.out.println("in prod service");
		Product product = new Product();
		product.setPname(p.getPname());
		product.setPcat(p.getPcat());
		product.setPrice(p.getPrice());
		product.setPhoto(storageService.store(pic));
		pdao.save(product);
		
	}

	@Override
	public List<Product> findProducts(int sellerId) {
		
		return pdao.findBySeller(sService.findById(sellerId),Sort.by(Sort.Direction.DESC,"prodid"));
	}

	@Override
	public void updateProduct(Product p) 
	{
		Product prod = pdao.getReferenceById(p.getProdid());
		p.setSeller(prod.getSeller());
		pdao.save(prod);
				
	}

	@Override
	public void deleteProduct(int prodid) {
		Product prod = pdao.getReferenceById(prodid);
		pdao.delete(prod);
		
	}

	@Override
	public List<Product> allProducts() {
		
		return pdao.findAll(Sort.by(Sort.Direction.DESC,"prodid"));
	}

	@Override
	public List<Product> categoryProducts(String pcat, String subcat) {
	
		return pdao.findByPcat(pcat, Sort.by(Sort.Direction.DESC,"prodid"));
	}

	@Override
	public Product findProductById(int prodid) {
		
		return pdao.getReferenceById(prodid);
	}

	@Override
	public Page<Product> allProductsPaginated(int page, int pagesize) {
		Page<Product> prods=pdao.findAll(PageRequest.of(page, pagesize,Sort.by(Direction.DESC, "prodid")));
		System.err.println(prods.getSize());
		return prods;
	
	}

}
