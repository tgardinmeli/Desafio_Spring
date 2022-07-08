package com.dh.meli.desafioSpring.exception;

import lombok.Builder;
import lombok.Data;

/**
 * Detalhes da exceção.
 */
@Data
@Builder
public class ExceptionsDetails {
    private String erro;
    private int statusHttp;
    private String mensagem;
}
