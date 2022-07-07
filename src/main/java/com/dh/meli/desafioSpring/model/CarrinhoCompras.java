package com.dh.meli.desafioSpring.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CarrinhoCompras {
    private int id;
    private List<Produto> articles;
    private double total;


}

