package com.shopping.shoppingApi.service.exeptions;

public class UserNotFoundExeption extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public UserNotFoundExeption(String msg) {
		super(msg);
	}
}
