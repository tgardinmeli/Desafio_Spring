package com.dh.meli.desafioSpring.service;

import com.dh.meli.desafioSpring.dto.ProdutoDto;
import com.dh.meli.desafioSpring.model.Produto;
import com.dh.meli.desafioSpring.repository.ProdutoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProdutoServiceImp implements ProdutoService{

    @Autowired
    private ProdutoRepo produtoRepo;



    @Override
    public ProdutoDto cadastrarProduto(Produto produto) {
        Produto produtoCadastrado = produtoRepo.cadastrarProduto(produto);

        ProdutoDto produtoDto = new ProdutoDto(produto);

        return produtoDto;
    }

    @Override
    public List<ProdutoDto> getAllProdutosDisponiveis() {
        List<Produto> listaDisponiveis = produtoRepo.getAll();
        List<ProdutoDto> listaDisponiveisDto = null;
        try{
            listaDisponiveisDto = listaDisponiveis.stream()
                    .filter(p -> p.getQuantity() > 0 )
                    .map(ProdutoDto::new)
                    .collect(Collectors.toList());

        } catch(Exception exception){

        }
        return listaDisponiveisDto;
    }

    @Override
    public List<ProdutoDto> getAllCategoria(String categoria) {
        List<Produto> listaCategoria = produtoRepo.getAll();
        List<ProdutoDto> listaCategoriaDto = null;
        try{
            listaCategoriaDto = listaCategoria.stream()
                    .filter(p -> p.getCategory().equalsIgnoreCase(categoria) )
                    .map(ProdutoDto::new)
                    .collect(Collectors.toList());

        } catch(Exception exception){

        }
        return listaCategoriaDto;
    }

    @Override
    public List<ProdutoDto> getAll(){
        List<ProdutoDto> listaDto = produtoRepo.getAll()
                .stream().map(ProdutoDto::new)
                .collect(Collectors.toList());
        return listaDto;
    }



}
