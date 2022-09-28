package com.app.pojos;

import javax.persistence.*;

@Entity
@Table
public class Admin {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id;
	@Column(length = 30)
	private String email;
	@Column(length = 255)
	private String pwd;
	@Column(length = 30)
	private String uname;
	

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	@Override
	public String toString() {
		return "Admin [Id=" + Id + ", email=" + email + ", pwd=" + pwd + ", uname=" + uname + "]";
	}
	
	
	
}
