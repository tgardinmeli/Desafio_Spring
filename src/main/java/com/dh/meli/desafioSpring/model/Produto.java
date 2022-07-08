package com.dh.meli.desafioSpring.model;

import lombok.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

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
    @NotNull
    private Long productId;
    @NotNull @NotEmpty
    private String name;
    @NotNull @NotEmpty
    private String category;
    private String brand;
    @NotNull
    private Double price;
    @NotNull
    private Integer quantity;
    @NotNull
    private Boolean freeShipping;
    @NotNull @NotEmpty
    private String prestige;

}
