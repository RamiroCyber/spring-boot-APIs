package com.shopping.shoppingApi.entitie;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.shopping.shoppingApi.dto.UserDTO;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;
	private String cpf;
	private String adress;
	private String email;
	private String phone;
	private Date dateRegister;

	public User() {
	}

	public Long getId() {
		return id;
	}

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

	public static User convert(UserDTO userDTO) {
		
		User user = new User();
		user.setName(userDTO.getName());
		user.setCpf(userDTO.getCpf());
		user.setAdress(userDTO.getAdress());
		user.setEmail(userDTO.getEmail());
		user.setPhone(userDTO.getPhone());
		user.setDateRegister(userDTO.getDateRegister());
		return user;
	}

}
