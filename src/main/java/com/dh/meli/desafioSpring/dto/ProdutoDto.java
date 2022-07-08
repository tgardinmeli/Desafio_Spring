package com.dh.meli.desafioSpring.dto;

import com.dh.meli.desafioSpring.model.Produto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProdutoDto {
    private Long productId; // do requisito
    private String name; // do requisito
    private String category; // escolha do grupo de retornar
    private Double price; // escolha do grupo de retornar
    private Integer quantity;  // do requisito

    public ProdutoDto(Produto produto) {
        this.productId = produto.getProductId();
        this.name = produto.getName();
        this.category = produto.getCategory();
        this.price = produto.getPrice();
        this.quantity= produto.getQuantity();
    }
}
