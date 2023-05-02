package com.example.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import lombok.Getter;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
@Getter
public class ResourceNotFoundException extends RuntimeException {
private String resourceName;
private String fieldName;
private long fieldValue;
public ResourceNotFoundException(String resourceName, String fieldName, long fieldValue) {
	super(String.format("%s is not found with %s:'%s'",resourceName,fieldName,fieldValue));
	this.resourceName = resourceName;
	this.fieldName = fieldName;
	this.fieldValue = fieldValue;
}
}
