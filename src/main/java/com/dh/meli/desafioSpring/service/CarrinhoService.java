package com.dh.meli.desafioSpring.service;

import com.dh.meli.desafioSpring.dto.RequestProdutoDto;
import com.dh.meli.desafioSpring.dto.TicketDto;
import com.dh.meli.desafioSpring.model.CarrinhoCompras;
import com.dh.meli.desafioSpring.model.Produto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Lista de métodos usados pela camada Service de Carrinho.
 * Implementação na classe CarrinhoServiceImp
 */
public interface CarrinhoService {
    HashMap <Long, Produto>verificarProduto(List<RequestProdutoDto> articlesPurchaseRequest);
    TicketDto processarCompra(List<RequestProdutoDto> articlesPurchaseRequest);
}
