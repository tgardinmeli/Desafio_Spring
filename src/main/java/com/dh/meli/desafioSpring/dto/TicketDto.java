package com.dh.meli.desafioSpring.dto;


import com.dh.meli.desafioSpring.model.CarrinhoCompras;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TicketDto { // receber o carrinho de compras do usuario (já conferido se tem os itens pedidos no estoque
    private CarrinhoCompras ticket;
}
