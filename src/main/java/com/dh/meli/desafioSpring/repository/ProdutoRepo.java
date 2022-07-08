package com.dh.meli.desafioSpring.repository;

import com.dh.meli.desafioSpring.model.Produto;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
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
        ObjectMapper mapper = new ObjectMapper();
        ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());
        List<Produto> listaAtual = getAll();
        try {
            List<Produto> listaCopia = new ArrayList<>(listaAtual);
            listaCopia.add(produto);
            writer.writeValue(new File(LINKFILE), listaCopia);

        } catch (Exception exception){
            System.out.println("PRODUTO NÃO CADASTRADO! ERRO!");
        }

    }

    public void atualizarListaProdutos(List<Produto> produtos) {
        ObjectMapper mapper = new ObjectMapper();
        ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());
        try {
            writer.writeValue(new File(LINKFILE), produtos);

        } catch (Exception exception){
            System.out.println("Deu ruim");
        }
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
