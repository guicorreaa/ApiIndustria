package com.industria.estoque.exception;

public class RawMaterialInUseException extends RuntimeException {
    public RawMaterialInUseException(String message) {
        super(message);
    }
}
