package com.dh.meli.desafioSpring.handler;

import com.dh.meli.desafioSpring.exception.NotFoundException;
import com.dh.meli.desafioSpring.exception.ExceptionsDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class NotFoundHandler {

    @ExceptionHandler(NotFoundException.class) // pega a classe do Not found generico
    public ResponseEntity<ExceptionsDetails> handlerNotFound(NotFoundException exception){
        return new ResponseEntity<>(
            ExceptionsDetails.builder()
                .erro("Produto não encontrato")
                .statusHttp(HttpStatus.NOT_FOUND.value())
                .mensagem(exception.getMessage())
                .build(),
                HttpStatus.N
    }

        )

    }
}

