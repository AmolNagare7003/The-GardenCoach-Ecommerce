package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.DTO.LoginDTO;
import com.app.DTO.Response;
import com.app.pojos.Admin;
import com.app.service.IAdminService;



@RestController
@RequestMapping("/api/admin")
@CrossOrigin
public class AdminController {
	
	@Autowired
	private IAdminService adminService;
	
	@PostMapping("/validate")
	public ResponseEntity<?> validateUser(@RequestBody LoginDTO ldto)
	{
		Admin admin = adminService.validate(ldto.getEmail(), ldto.getPwd());
		if(admin!=null)
			return Response.success(admin);
		else
			return Response.status(HttpStatus.NOT_FOUND);
		
	}
	
	@PostMapping
	//Update the admin profile 
	public ResponseEntity<?> updateAdminProfile(@RequestBody Admin admin)
	{
		adminService.updateAdmin(admin);
		return Response.status(HttpStatus.OK);
	}
	
	

}
