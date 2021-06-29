package com.devops.agentapp.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.devops.agentapp.exception.ProductNotFoundException;

@RestControllerAdvice
class ProductNotFoundAdvice {

  @ResponseBody
  @ExceptionHandler(ProductNotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  String productNotFoundHandler(ProductNotFoundException ex) {
    return ex.getMessage();
  }
}