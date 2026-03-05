package com.industria.estoque.common;

import com.industria.estoque.exception.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ProductAlreadyExistsException.class)
    public ResponseEntity<String> handleProductAlreadyExistsException(ProductAlreadyExistsException e) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
    }

    @ExceptionHandler(ProductNoExistsException.class)
    public ResponseEntity<String> handleProductNoExistsException(ProductNoExistsException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }

    @ExceptionHandler(ProductInUseException.class)
    public ResponseEntity<String> handleProductInUseException(ProductInUseException e) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
    }

    @ExceptionHandler(RawMaterialAlreadyExistsException.class)
    public ResponseEntity<String> handleRawMaterialAlreadyExistsException(RawMaterialAlreadyExistsException e) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
    }

    @ExceptionHandler(RawMaterialNoExistsException.class)
    public ResponseEntity<String> handleRawMaterialNoExistsException(RawMaterialNoExistsException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }

    @ExceptionHandler(RawMaterialInUseException.class)
    public ResponseEntity<String> handleRawMaterialInUseException(RawMaterialInUseException e) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
    }

}


