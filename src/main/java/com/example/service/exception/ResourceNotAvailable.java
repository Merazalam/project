package com.example.service.exception;

public class ResourceNotAvailable extends RuntimeException{
	public ResourceNotAvailable(String message){
		super(message);
	}
}
