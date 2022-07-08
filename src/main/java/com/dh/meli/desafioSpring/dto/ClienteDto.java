package com.dh.meli.desafioSpring.dto;

import com.dh.meli.desafioSpring.model.Cliente;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ClienteDto {
    private String nome;
    private String estado;


    public ClienteDto(Cliente cliente){
        this.nome = cliente.getNome();
        this.estado = cliente.getEstado();
    }
}