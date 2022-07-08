package com.dh.meli.desafioSpring.service;

import com.dh.meli.desafioSpring.dto.ProdutoDto;
import com.dh.meli.desafioSpring.model.Produto;

import java.util.List;

/**
 * Interface ProdutoService: lista de métodos usados pela camada Service de Produto.
 * Implementação na classe ProdutoServiceImp
 */
public interface ProdutoService {
    ProdutoDto cadastrarProduto(Produto produto);
    List<ProdutoDto> getAllProdutosDisponiveis();
    List<ProdutoDto> getAllCategoria(String categoria);
    List<ProdutoDto> getAll();
    List<ProdutoDto> getByCategoryAndFree(String category, boolean freeShipping);
    List<ProdutoDto> getByCategoryAndPrestige(String category, String prestige);
    List<ProdutoDto> getByCategoryFreeOrdered(String category, boolean freeShipping, int order);
}
