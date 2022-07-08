package com.dh.meli.desafioSpring.repository;

import com.dh.meli.desafioSpring.model.Cliente;
import com.dh.meli.desafioSpring.model.Produto;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class ClienteRepo {
    private final String LINKCLIENTE = "src/main/resources/clientes.json";

    public void cadastrarCliente(Cliente cliente) {
        ObjectMapper mapper = new ObjectMapper();
        ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());
        List<Cliente> listaAtual = getAll();
        try {
            List<Cliente> listaCopia = new ArrayList<>(listaAtual);
            listaCopia.add(cliente);
            writer.writeValue(new File(LINKCLIENTE), listaCopia);

        } catch (Exception exception){
            System.out.println("Cliente não cadastrao");
        }
    }
    public List<Cliente> getAll() {
        ObjectMapper mapper = new ObjectMapper();
        List<Cliente> lista = null;

        try{
            lista = Arrays.asList(mapper.readValue(new File(LINKCLIENTE), Cliente[].class));

        } catch(Exception ex){

        }
        return lista;
    }

}
