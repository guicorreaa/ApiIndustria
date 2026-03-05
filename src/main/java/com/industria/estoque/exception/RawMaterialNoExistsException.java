package com.industria.estoque.exception;

public class RawMaterialNoExistsException extends RuntimeException {
    public RawMaterialNoExistsException(String message) {
        super(message);
    }
}
