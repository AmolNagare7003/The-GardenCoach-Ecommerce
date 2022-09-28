package com.app.DTO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

 // in DTO, you can add those fields that are required for client.
//The Entity and DTO fields look the same but make that you will 
//add fields that are required to the client.
public class CartDTO 
{
	private int prodid;
	private String pcat;
	private String pname;
	private int price;
	private int qty;
	
	
	
	
	

}
