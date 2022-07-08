package com.dh.meli.desafioSpring.model;

import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {
    @NotNull
    private Long clienteID;
    @NotNull
    @NotEmpty
    private String nome;
    @NotNull @NotEmpty
    private String estado;
    @NotNull @NotEmpty
    private String CPF;
}
