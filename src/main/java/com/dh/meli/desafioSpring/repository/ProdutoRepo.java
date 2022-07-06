package com.dh.meli.desafioSpring.repository;

import com.dh.meli.desafioSpring.model.Produto;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProdutoRepo {

    private final String LINKFILE = "src/main/resources/produtos.json";

    public void cadastrarProduto(Produto produto) {

    }

    public List<Produto> getAllProdutosDisponiveis() {
        return null;
    }


    public List<Produto> getAllCategoria(String categoria) {
        return null;
    }
}
