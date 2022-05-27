package com.shopping.shoppingApi.entitie;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.shopping.shoppingApi.dto.UserDTO;

@Entity
@Table(name = "TB_USERS")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;

	@Column(nullable = false, length = 50)
	private String name;
	@Column(nullable = false, length = 11)
	private String cpf;
	@Column(nullable = false, length = 50)
	private String adress;
	@Column(nullable = false, length = 50)
	private String email;
	@Column(nullable = false, length = 15)
	private String phone;
	@Column(nullable = false)
	private LocalDateTime dateRegister;

	public User() {
	}

	public UUID getId() {
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

	public LocalDateTime getDateRegister() {
		return dateRegister;
	}

	public void setDateRegister(LocalDateTime dateRegister) {
		this.dateRegister = dateRegister;
	}

}
