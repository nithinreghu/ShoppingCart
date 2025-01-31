package com.shopping.exception.handler;

import com.shopping.exception.ItemNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ShoppingExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = ItemNotFoundException.class)
    protected ResponseEntity<Object> handleNotFound(ItemNotFoundException ex, WebRequest request) {
        return handleExceptionInternal(ex, "not found", new HttpHeaders(), HttpStatus.NOT_FOUND,
                request);
    }

}
