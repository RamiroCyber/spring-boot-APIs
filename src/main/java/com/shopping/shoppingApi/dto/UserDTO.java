package com.shopping.shoppingApi.dto;

import java.util.Date;

import com.shopping.shoppingApi.entitie.User;

public class UserDTO {

	private String name;
	private String cpf;
	private String adress;
	private String email;
	private String phone;
	private Date dateRegister;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getDateRegister() {
		return dateRegister;
	}

	public void setDateRegister(Date dateRegister) {
		this.dateRegister = dateRegister;
	}

	public static UserDTO convert(User user) {

		UserDTO userDTO = new UserDTO();
		userDTO.setName(user.getName());
		userDTO.setCpf(user.getCpf());
		userDTO.setAdress(user.getAdress());
		userDTO.setEmail(user.getEmail());
		userDTO.setPhone(user.getPhone());
		userDTO.setDateRegister(user.getDateRegister());
		return userDTO;
	}

}
