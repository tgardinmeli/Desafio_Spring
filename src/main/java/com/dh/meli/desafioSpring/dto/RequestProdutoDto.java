package com.dh.meli.desafioSpring.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Receber carrinho de compras do usuário.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RequestProdutoDto {
    private int quantity;
    private Long productId;
}
