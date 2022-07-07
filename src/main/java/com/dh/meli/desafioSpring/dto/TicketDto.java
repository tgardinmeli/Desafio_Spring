package com.dh.meli.desafioSpring.dto;


import com.dh.meli.desafioSpring.model.CarrinhoCompras;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class TicketDto { // receber o carrinho de compras do usuario (já conferido se tem os itens pedidos no estoque
    List<CarrinhoCompras> ticket = new ArrayList<CarrinhoCompras>();

}
