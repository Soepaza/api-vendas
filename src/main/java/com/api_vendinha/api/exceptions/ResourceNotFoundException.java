package com.api_vendinha.api.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serializable;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException implements Serializable {
    public static final Long serialVersionUID = 1L;
    public ResourceNotFoundException(String ex){
        super();
    }
}
