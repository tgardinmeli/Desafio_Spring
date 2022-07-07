package com.dh.meli.desafioSpring.service;

import com.dh.meli.desafioSpring.dto.RequestProdutoDto;
import com.dh.meli.desafioSpring.dto.TicketDto;

import java.util.ArrayList;
import java.util.List;

public interface CarrinhoService {
    boolean verificarProduto(List<RequestProdutoDto> articlesPurchaseRequest);
    List<TicketDto> processarCompra(List<RequestProdutoDto> articlesPurchaseRequest);

}
