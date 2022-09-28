package com.app.service;

import com.app.pojos.Admin;

public interface IAdminService 
{
	Admin validate(String email,String pwd);
	void updateAdmin(Admin admin);
	long countAdmin();

}
