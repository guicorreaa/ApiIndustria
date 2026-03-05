package com.industria.estoque.exception;

public class RawMaterialAlreadyExistsException extends RuntimeException {
    public RawMaterialAlreadyExistsException(String message) {
        super(message);
    }
}
