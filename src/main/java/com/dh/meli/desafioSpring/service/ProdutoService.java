package com.dh.meli.desafioSpring.service;

import com.dh.meli.desafioSpring.dto.ProdutoDto;
import com.dh.meli.desafioSpring.model.Produto;

import java.util.List;

public interface ProdutoService {
    ProdutoDto cadastrarProduto(Produto produto);
    List<ProdutoDto> getAllProdutosDisponiveis();
    List<ProdutoDto> getAllCategoria(String categoria);
    List<ProdutoDto> getAll();

}
