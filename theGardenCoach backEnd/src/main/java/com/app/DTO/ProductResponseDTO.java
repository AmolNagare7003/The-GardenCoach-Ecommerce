package com.app.DTO;


import org.springframework.beans.BeanUtils;

import com.app.pojos.Product;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductResponseDTO 
{	
	//private String brand;
	private int prodid;
	private String pname;
	private String pcat;
	private String subcat;
	private int price;
	private int sellerId;
	private String sellerName;
	private String photo;
	
	public static ProductResponseDTO fromProductEntity(Product pEntity) {
		ProductResponseDTO pdto = new ProductResponseDTO();
		pdto.setSellerId(pEntity.getSeller().getId());
		pdto.setSellerName(pEntity.getSeller().getName());
		BeanUtils.copyProperties(pEntity, pdto);
		
		return pdto;
	}

}
