package com.app.DTO;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ProductPageResponseDTO {

	private List<ProductResponseDTO> plist;
	private int current;
	private long total;
	private int pagesize;
	
	
}
