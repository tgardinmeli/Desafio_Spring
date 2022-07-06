package com.dh.meli.desafioSpring.repository;

import com.dh.meli.desafioSpring.model.Produto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ProdutoRepo {

    private final String LINKFILE = "src/main/resources/produtos.json";

    public void cadastrarProduto(Produto produto) {

    }

    public List<Produto> getAllProdutosDisponiveis() {
        List<Produto> listaDisponiveis = getAll();
        try{
             listaDisponiveis = listaDisponiveis.stream().filter(p -> p.getQuantity() > 0).collect(Collectors.toList());


        } catch(Exception ex){

        }

        return null;
    }


    public List<Produto> getAllCategoria(String categoria) {
        return null;
    }

    public List<Produto> getAll() {
        ObjectMapper mapper = new ObjectMapper();
        List<Produto> lista = null;

        try{
            lista = Arrays.asList(mapper.readValue(new File(LINKFILE), Produto[].class));

        } catch(Exception ex){

        }
        return lista;
    }



    }
