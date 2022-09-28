package com.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.Dao.IAdminDao;
import com.app.pojos.Admin;

@Service
public class AdminServiceImpl implements IAdminService {

	@Autowired
	private IAdminDao adao;
	@Override
	public Admin validate(String email, String pwd) {
		Optional<Admin> admin = adao.findById(email);
		if(admin.isPresent() && admin.get().getPwd().equals(pwd)) 
		{
		return admin.get();
		}
		return null;
	}

	@Override
	public void updateAdmin(Admin admin) 
	{
		if(admin.getPwd().equals("") || admin.getPwd() == null)
		{
			admin.setPwd(adao.getReferenceById(admin.getEmail()).getPwd());
		}
		adao.save(admin);
		
		
	}

	@Override
	public long countAdmin() {
		
		return adao.count();
	}

}
