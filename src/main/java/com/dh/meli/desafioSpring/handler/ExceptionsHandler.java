package com.dh.meli.desafioSpring.handler;

import com.dh.meli.desafioSpring.exception.NotFoundException;
import com.dh.meli.desafioSpring.exception.QuantityException;
import com.dh.meli.desafioSpring.exception.ExceptionsDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Manipula as exceções.
 */
@ControllerAdvice
public class ExceptionsHandler {

    /**
     * Manipula exceção de item não encontrado.
     * @param exception
     * @return ResponseEntity<ExceptionsDetails>
     */
    @ExceptionHandler(NotFoundException.class) // pega a classe do Not found generico
    public ResponseEntity<ExceptionsDetails> handlerNotFound(NotFoundException exception) {
        return new ResponseEntity<>(
                ExceptionsDetails.builder()
                        .erro("ERRO - NÃO ENCONTRADO")
                        .statusHttp(HttpStatus.NOT_FOUND.value())
                        .message(exception.getMessage())
                        .build(),
                HttpStatus.NOT_FOUND); // 4o4
    }

    /**
     * Manipula exceção de quantidade.
     * @param exception
     * @return ResponseEntity<ExceptionsDetails>
     */
    @ExceptionHandler(QuantityException.class)
    public ResponseEntity<ExceptionsDetails> handlerQuantityException(QuantityException exception){
        return new ResponseEntity<>(
                ExceptionsDetails.builder()
                .erro("ERRO - QUANTIDADE")
                        .statusHttp(HttpStatus.REQUESTED_RANGE_NOT_SATISFIABLE.value())
                        .message(exception.getMessage())
                        .build(),
                HttpStatus.REQUESTED_RANGE_NOT_SATISFIABLE); // 416
    }


    /**
     * Manipula exceção de dados inválidos.
     * @param exception
     * @return ResponseEntity<ExceptionsDetails>
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ExceptionsDetails> handlerInvalidData(MethodArgumentNotValidException exception){
        return new ResponseEntity<>(
                ExceptionsDetails.builder()
                        .erro("ERRO - DADOS INVÁLIDOS")
                        .statusHttp(HttpStatus.BAD_REQUEST.value())
                        .message(exception.getMessage())
                        .build(),
                HttpStatus.BAD_REQUEST); // 400
    }

}

