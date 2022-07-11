package com.dh.meli.desafioSpring.dto;

import com.dh.meli.desafioSpring.model.CarrinhoCompras;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Receber o carrinho de compras do usuario (já conferido se tem os itens pedidos no estoque).
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TicketDto { //
    private CarrinhoCompras ticket;
}
