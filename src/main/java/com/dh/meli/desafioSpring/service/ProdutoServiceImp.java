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
    public void cadastrarProduto(Produto produto) {
        produtoRepo.cadastrarProduto(produto);
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

    @Override
    public List<ProdutoDto> getByCategoryAndFree(String category, boolean freeShipping) {
        List<Produto> allProducts = produtoRepo.getAll();
        List<ProdutoDto> listaFiltrosDto = null;
        try{
            listaFiltrosDto = allProducts.stream()
                    .filter(p -> p.getCategory().equalsIgnoreCase(category) && p.getFreeShipping().equals(freeShipping))
                    .map(ProdutoDto::new)
                    .collect(Collectors.toList());

        } catch(Exception exception){

        }
        return listaFiltrosDto;
    }

    @Override
    public List<ProdutoDto> getByCategoryAndPrestige(String category, String prestige) {
        List<Produto> allProducts = produtoRepo.getAll();
        List<ProdutoDto> listaFiltrosDto = null;
        try{
            listaFiltrosDto = allProducts.stream()
                    .filter(p -> p.getCategory().equalsIgnoreCase(category) && p.getPrestige().equals(prestige))
                    .map(ProdutoDto::new)
                    .collect(Collectors.toList());

        } catch(Exception exception){

        }
        return listaFiltrosDto;
    }


    @Override
    public List<ProdutoDto> getByCategoryFreeOrdered(String category, boolean freeShipping, int order) {
        List<ProdutoDto> listOrdered = this.getByCategoryAndFree(category, freeShipping);
        switch(order) {
            case 0:
                return listOrdered.stream().sorted((p1,p2)-> p1.getName().compareTo(p2.getName())).collect(Collectors.toList());
            case 1:
                return listOrdered.stream().sorted((p1,p2)-> p2.getName().compareTo(p1.getName())).collect(Collectors.toList());
            case 2:
                return listOrdered.stream().sorted((p1,p2)-> p1.getPrice().compareTo(p2.getPrice())).collect(Collectors.toList());
            case 3:
                return listOrdered.stream().sorted((p1,p2)-> p2.getPrice().compareTo(p1.getPrice())).collect(Collectors.toList());
            default:
                return null;
        }
    }

}

