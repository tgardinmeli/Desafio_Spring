package com.dh.meli.desafioSpring.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Exceção lançada quando a quantidade requisitada do produto é maior que a quantidade em estoque.
 */
@ResponseStatus(HttpStatus.REQUESTED_RANGE_NOT_SATISFIABLE)
public class QuantityException extends RuntimeException {
        public QuantityException(String message) {
            super(message);
        }
 }

