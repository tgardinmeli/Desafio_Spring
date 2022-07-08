package com.dh.meli.desafioSpring.service;

import com.dh.meli.desafioSpring.dto.RequestProdutoDto;
import com.dh.meli.desafioSpring.dto.TicketDto;
import com.dh.meli.desafioSpring.exception.NotFoundException;
import com.dh.meli.desafioSpring.exception.QuantityException;
import com.dh.meli.desafioSpring.model.CarrinhoCompras;
import com.dh.meli.desafioSpring.model.Produto;
import com.dh.meli.desafioSpring.repository.ProdutoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

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
                if(hash.get(i).getQuantity() < produto.getQuantity()){ // quantidade insuficiente
                    throw new QuantityException("Quantidade insuficiente no estoque");
                }

            }else { // não encontrado
                throw new NotFoundException("Item não encontrado");
            }
        }
        return hash;
    }

    @Override
    public TicketDto processarCompra(List<RequestProdutoDto> articlesPurchaseRequest) {

        if(!articlesPurchaseRequest.isEmpty()){
            HashMap<Long, Produto> hashRecebido = verificarProduto(articlesPurchaseRequest);
            // ticket (id e articles []  total
            List<Produto> produtos = new ArrayList<Produto>();

            articlesPurchaseRequest.stream().forEach(p -> {
                hashRecebido.get(p.getProductId()).setQuantity(p.getQuantity());
                produtos.add(hashRecebido.get(p.getProductId()));
            });

            double total = produtos.stream().mapToDouble(p-> (p.getPrice() * p.getQuantity())).sum();

            CarrinhoCompras carrinho = new CarrinhoCompras(produtos, total);
            TicketDto ticket = new TicketDto(carrinho);
            atualizarListaJson(hashRecebido, verificarProduto(articlesPurchaseRequest));
            return ticket;
        }
        else{
            throw new NotFoundException("Você não incluiu produtos no seu carrinho!");
        }
    }

    public void atualizarListaJson(HashMap<Long, Produto> hashModificado, HashMap<Long, Produto> hashOriginal) {
        List<Produto> produtosAtualizados = new ArrayList<Produto>();
        for(Long key : hashModificado.keySet()) {
            if(hashModificado.get(key).getQuantity() !=  hashOriginal.get(key).getQuantity()) {
                int quantidade = hashOriginal.get(key).getQuantity() - hashModificado.get(key).getQuantity();
                hashOriginal.get(key).setQuantity(quantidade);
                produtosAtualizados.add(hashOriginal.get(key));
            } else {
                produtosAtualizados.add(hashOriginal.get(key));
            }
        }

        produtoRepo.atualizarListaProdutos(produtosAtualizados);
        // escreve no json com lista produtosAtualizados
    }
}
