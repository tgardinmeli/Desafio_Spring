package com.dh.meli.desafioSpring.service;

import com.dh.meli.desafioSpring.dto.RequestProdutoDto;
import com.dh.meli.desafioSpring.dto.TicketDto;
import com.dh.meli.desafioSpring.exception.NotFoundException;
import com.dh.meli.desafioSpring.model.CarrinhoCompras;
import com.dh.meli.desafioSpring.model.Produto;
import com.dh.meli.desafioSpring.repository.ProdutoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

@Service
public class CarrinhoServiceImp implements CarrinhoService{

    @Autowired
    private ProdutoRepo produtoRepo;


    @Override
    public HashMap<Long, Produto> verificarProduto(List<RequestProdutoDto> articlesPurchaseRequest) {

        final HashMap<Long, Produto> hash = new HashMap<Long, Produto>();
        List<Produto> lista = produtoRepo.getAll();
        lista.stream().forEach(p -> hash.put(p.getProductId(), p));

        for(RequestProdutoDto produto : articlesPurchaseRequest){
            Long i = produto.getProductId();
            if(hash.containsKey(i)){
                if(hash.get(i).getQuantity() <= produto.getQuantity()){
                    return null ;
                }

            }else {
                return null;
            }
        }
        return hash;
    }

    @Override
    public TicketDto processarCompra(List<RequestProdutoDto> articlesPurchaseRequest) {
        HashMap<Long, Produto> hashRecebido = verificarProduto(articlesPurchaseRequest);

        if(hashRecebido != null){
            // ticket (id e articles []  total
            List<Produto> produtos = new ArrayList<Produto>();

            articlesPurchaseRequest.stream().forEach(p -> {
                hashRecebido.get(p.getProductId()).setQuantity(p.getQuantity());
                produtos.add(hashRecebido.get(p.getProductId()));
            });

            double total = produtos.stream().mapToDouble(p-> (p.getPrice() * p.getQuantity())).sum();

            CarrinhoCompras carrinho = new CarrinhoCompras(produtos, total);
            TicketDto ticket = new TicketDto(carrinho);
            return ticket;
        }
        else{
            throw new NotFoundException("Produto não tem estoque!!!!!!!!!");
        }
    }

//
//    public void atualizarListaJson(List<Produto> produto){
//        List<Produto> listaAntiga = produtoRepo.getAll();
//        for(Produto produtoAtual : produto){
//            listaAntiga.get(produto).setQuantity()
//
//        }
//
//    }
}
