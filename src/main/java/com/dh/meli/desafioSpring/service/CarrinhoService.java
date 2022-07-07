package com.dh.meli.desafioSpring.service;

import com.dh.meli.desafioSpring.dto.RequestProdutoDto;
import com.dh.meli.desafioSpring.dto.TicketDto;
import com.dh.meli.desafioSpring.model.CarrinhoCompras;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public interface CarrinhoService {
    HashMap verificarProduto(List<RequestProdutoDto> articlesPurchaseRequest);
    TicketDto processarCompra(List<RequestProdutoDto> articlesPurchaseRequest);

}
