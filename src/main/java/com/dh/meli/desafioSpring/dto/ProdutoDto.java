package com.dh.meli.desafioSpring.dto;

import com.dh.meli.desafioSpring.model.Produto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProdutoDto {
    private String name;
    private String category;
    private Double price;

    public ProdutoDto(Produto produto) {
        this.name = produto.getName();
        this.category = produto.getCategory();
        this.price = produto.getPrice();
    }
}
