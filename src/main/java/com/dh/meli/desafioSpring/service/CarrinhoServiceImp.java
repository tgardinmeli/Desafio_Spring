package com.dh.meli.desafioSpring.service;

import com.dh.meli.desafioSpring.dto.RequestProdutoDto;
import com.dh.meli.desafioSpring.dto.TicketDto;
import com.dh.meli.desafioSpring.exception.NotFoundException;
import com.dh.meli.desafioSpring.model.Produto;
import com.dh.meli.desafioSpring.repository.ProdutoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class CarrinhoServiceImp implements CarrinhoService{

    @Autowired
    private ProdutoRepo produtoRepo;

//    @Autowired
//    private ProdutoServiceImp produtoService;


    @Override
    public boolean verificarProduto(List<RequestProdutoDto> articlesPurchaseRequest) {

        final HashMap<Long, Produto> hash = new HashMap<Long, Produto>();
        List<Produto> lista = produtoRepo.getAll();
        lista.stream().forEach(p -> hash.put(p.getProductId(), p));

        for(RequestProdutoDto produto : articlesPurchaseRequest){
            if(hash.containsKey(produto.getProductId())){
                if(hash.get(produto.getProductId()).getQuantity() < produto.getQuantity()){
                    return false ;
                }

            }else {
                return false;
            }
        }
        return true;
    }

    @Override
    public List<TicketDto> processarCompra(List<RequestProdutoDto> articlesPurchaseRequest) {
        if(verificarProduto(articlesPurchaseRequest)){

        }
        else{
            throw new NotFoundException("Produto não tem estoque");
        }
        return null;
    }


}
