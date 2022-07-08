package com.dh.meli.desafioSpring.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Representa um carrinho (pedido) de compras.
 */
@Getter
@Setter
@NoArgsConstructor

public class CarrinhoCompras {
    @NotNull
    private int id;
    @NotNull
    private List<Produto> articles;
    @NotNull
    private double total;
    private static int contador = 1;

    /**
     * Seta atributos de carrinho.
     * @param articles
     * @param total
     */
    public CarrinhoCompras(List<Produto> articles, double total){
        this.id = this.contador;
        this.articles = articles;
        this.total = total;
        contador++;
    }

}