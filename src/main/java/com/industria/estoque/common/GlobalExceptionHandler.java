package com.industria.estoque.common;

import com.industria.estoque.exception.ProductAlreadyExistsException;
import com.industria.estoque.exception.ProductInUseException;
import com.industria.estoque.exception.ProductNoExistsException;
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
        return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
    }

    @ExceptionHandler(ProductInUseException.class)
    public ResponseEntity<String> handleProductInUseException(ProductInUseException e) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
    }

}


