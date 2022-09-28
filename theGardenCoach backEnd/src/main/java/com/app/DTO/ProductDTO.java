package com.app.DTO;

import org.springframework.beans.BeanUtils;

import com.app.pojos.Product;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

public class ProductDTO {
	private int prodid;
	private String pname;
	private String pcat;
	private String subcat;
	private int price;
	private int sellerId;

	@JsonProperty(access = Access.READ_ONLY)
	private String pic;

	public static Product toProductEntity(ProductDTO pdto) {
		System.out.println("in productDTO " + pdto);
		Product pEntity = new Product();
		BeanUtils.copyProperties(pdto, pEntity);
		return pEntity;

	}

	public int getProdid() {
		return prodid;
	}

	public void setProdid(int prodid) {
		this.prodid = prodid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getPcat() {
		return pcat;
	}

	public void setPcat(String pcat) {
		this.pcat = pcat;
	}

	public String getSubcat() {
		return subcat;
	}

	public void setSubcat(String subcat) {
		this.subcat = subcat;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getSellerId() {
		return sellerId;
	}

	public void setSellerId(int sellerId) {
		this.sellerId = sellerId;
	}

//	public String getBrand() {
//		return brand;
//	}
//
//	public void setBrand(String brand) {
//		this.brand = brand;
//	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	@Override
	public String toString() {
		return "ProductDTO [prodid=" + prodid + ", pname=" + pname + ", pcat=" + pcat + ", subcat=" + subcat
				+ ", price=" + price + ", sellerId=" + sellerId + " Photo=" + pic + "]";
	}

}
