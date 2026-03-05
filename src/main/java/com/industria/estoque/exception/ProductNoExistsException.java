package com.industria.estoque.exception;

public class ProductNoExistsException extends RuntimeException {
    public ProductNoExistsException(String message) {
        super(message);
    }
}
