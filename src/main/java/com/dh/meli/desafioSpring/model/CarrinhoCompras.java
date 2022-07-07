package com.dh.meli.desafioSpring.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor

public class CarrinhoCompras {
    private int id;
    private List<Produto> articles;
    private double total;
    private static int contador = 1;

    public CarrinhoCompras(List<Produto> articles, double total){
        this.id = this.contador;
        this.articles = articles;
        this.total = total;
        contador++;
    }

}