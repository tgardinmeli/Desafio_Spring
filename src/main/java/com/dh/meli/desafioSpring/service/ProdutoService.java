package com.dh.meli.desafioSpring.service;

import com.dh.meli.desafioSpring.dto.ProdutoDto;
import com.dh.meli.desafioSpring.model.Produtos;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ProdutoService {
    void cadastrarProduto(Produtos produto);
    List<ProdutoDto> getAllProdutosDisponiveis();
    List<ProdutoDto> getAllCategoria(String categoria);

}
