package com.company.ecommerce.adapters.rest.exception;

public class MissingParameterException extends RuntimeException {
    public MissingParameterException() {
        super("Missing required parameter");
    }
}