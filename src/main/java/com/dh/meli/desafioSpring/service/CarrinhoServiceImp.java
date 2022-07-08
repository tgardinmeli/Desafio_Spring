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
import java.util.stream.Collectors;

/**
 * Implementação dos métodos da interface CarrinhoService.
 */
@Service
public class CarrinhoServiceImp implements CarrinhoService{

    @Autowired
    private ProdutoRepo produtoRepo;


    /**
     * Inicia com uma lista de todos os produtos cadastrados,
     * transforma num hash que tem o id do produto como chave
     * e o produto como valor.
     * Pega o id do produto do pedido da compra,
     * verifica se o id existe na lista de produtos cadastrados.
     * Se a quantidade do produto cadastrado for maior
     * que a quantidade de produto no pedido da compra,
     * retorna hash com produtos do pedido.
     * @param articlesPurchaseRequest
     * @return hash
     */
    @Override
    public HashMap<Long, Produto> verificarProduto(List<RequestProdutoDto> articlesPurchaseRequest) {

        final HashMap<Long, Produto> hash = new HashMap<Long, Produto>();
        List<Produto> lista = produtoRepo.getAll();
        lista.stream().forEach(p -> hash.put(p.getProductId(), p));

        for(RequestProdutoDto produto : articlesPurchaseRequest){
            Long i = produto.getProductId();
            if(hash.containsKey(i)){
                if(hash.get(i).getQuantity() < produto.getQuantity()){
                    return null ;
                }

            }else {
                return null;
            }
        }
        return hash;
    }

    /**
     * Inicia com o retorno do método verificarProduto
     * que é um hash com os produtos do pedido.
     * Calcula o preço total, adiciona produto e total ao carrinho,
     * cria um ticket a partir do carrinho
     * e atualiza a lista de produtos cadastrados.
     * Em caso de exceção, retorna mensagem de erro.
     * @param articlesPurchaseRequest
     * @return ticket
     */
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
            atualizarListaJson(hashRecebido, verificarProduto(articlesPurchaseRequest));
            return ticket;
        }
        else{
            throw new NotFoundException("Produto não tem estoque!!!!!!!!!");
        }
    }

    /**
     * Atualiza quantidade de produtos na lista de produtos cadastrados.
     * @param hashModificado
     * @param hashOriginal
     */
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
