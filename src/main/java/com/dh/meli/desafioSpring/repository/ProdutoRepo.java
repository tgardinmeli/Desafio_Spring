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

/**
 * Repositório de Produto
 */
@Repository
public class ProdutoRepo {

    private final String LINKFILE = "src/main/resources/produtos.json";

    /**
     * Inicia com uma cópia da lista atual de todos os produtos
     * e adiciona um novo produto a essa nova lista.
     * Adiciona o novo produto a produtos.json através do método writeValue.
     * Em caso de exceção, retorna mensagem de erro.
     * @param produto
     */
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

    /**
     * Atualiza lista de produtos no arquivo json.
     * @param produtos
     */
    public void atualizarListaProdutos(List<Produto> produtos) {
        ObjectMapper mapper = new ObjectMapper();
        ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());
        try {
            writer.writeValue(new File(LINKFILE), produtos);
        } catch (Exception exception){
            System.out.println("Deu ruim");
        }
    }

    /**
     * Retorna lista de produtos cadastrados em produtos.json
     * @return lista com todos os produtos cadastrados
     */
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
