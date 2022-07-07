package com.dh.meli.desafioSpring.model;

import lombok.*;

/**
 * Classe Produto representa um produto com atributos de
 * id, nome, categoria, marca, preço, quantidade, frete grátis e avaliação.
 */
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Produto {
    private long productId;
    private String name;
    private String category;
    private String brand;
    private Double price;
    private Integer quantity;
    private Boolean freeShipping;
    private String prestige;

}
