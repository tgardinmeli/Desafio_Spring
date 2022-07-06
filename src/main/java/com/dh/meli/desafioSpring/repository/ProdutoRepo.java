package com.dh.meli.desafioSpring.repository;

import com.dh.meli.desafioSpring.dto.ProdutoDto;
import com.dh.meli.desafioSpring.model.Produtos;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProdutoRepo {

    private final String LINKFILE = "src/main/resources/produtos.json";

    public void cadastrarProduto(Produtos produto) {

    }

    public List<Produtos> getAllProdutosDisponiveis() {
        return null;
    }


    public List<Produtos> getAllCategoria(String categoria) {
        return null;
    }
}
