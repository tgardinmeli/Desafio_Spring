package com.dh.meli.desafioSpring.service;

import com.dh.meli.desafioSpring.dto.ProdutoDto;
import com.dh.meli.desafioSpring.model.Produtos;
import com.dh.meli.desafioSpring.repository.ProdutoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoServiceImp implements ProdutoService{

    @Autowired
    private ProdutoRepo produtoRepo;


    @Override
    public void cadastrarProduto(Produtos produto) {

    }

    @Override
    public List<ProdutoDto> getAllProdutosDisponiveis() {
        return null;
    }

    @Override
    public List<ProdutoDto> getAllCategoria(String categoria) {
        return null;
    }
}
