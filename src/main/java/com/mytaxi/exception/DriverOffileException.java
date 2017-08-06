package com.mytaxi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Some constraints are violated ...")
public class DriverOffileException extends Exception{

	private static final long serialVersionUID = -3387516993224229948L;
	
	public DriverOffileException(String message){
		super(message);
	}

}
