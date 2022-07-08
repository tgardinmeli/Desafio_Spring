package com.dh.meli.desafioSpring.controller;

import com.dh.meli.desafioSpring.dto.ProdutoDto;
import com.dh.meli.desafioSpring.model.Produto;
import com.dh.meli.desafioSpring.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;


import java.util.List;

/**
 * Controller de produto.
 */
@RestController
@RequestMapping("/api/v1")
public class ProdutoController {

    @Autowired
    private ProdutoService service;


    /**
     * Recebe um objeto Produto com todos seus atributos no body do request,
     * chama o método de ProdutoService para cadastro do produto.
     * @param produto
     */
    @PostMapping("/insert-articles-request")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ProdutoDto> cadastrarProduto(@RequestBody @Valid Produto produto){
        return ResponseEntity.ok(service.cadastrarProduto(produto)) ;
    }

    /**
     * Retorna lista com todos os produtos disponíveis.
     * @return ResponseEntity.ok(service.getAllProdutosDisponiveis())
     */
    @GetMapping("/articles")
    public ResponseEntity<List<ProdutoDto>> getAllProdutosDisponiveis() {
        return ResponseEntity.ok(service.getAllProdutosDisponiveis());
    }

    /**
     * Retorna lista com todos os produtos disponíveis de uma certa categoria.
     * @param category
     * @return ResponseEntity.ok(service.getAllCategoria(category))
     */
    @GetMapping("/articles/") // gambiarra autorizada pelo Mauri!
    public ResponseEntity<List<ProdutoDto>> getAllCategoria
            (@RequestParam String category){
        return ResponseEntity.ok(service.getAllCategoria(category));
    }

    /**
     * Retorna lista com todos os produtos cadastrados.
     * @return ResponseEntity.ok(service.getAll())
     */
    @GetMapping("/articles/all")
    public ResponseEntity<List<ProdutoDto>> getAll(){
        return ResponseEntity.ok(service.getAll());
    }

    /**
     * Retorna lista com todos os produtos disponíveis,
     * filtrados por categoria e frete grátis.
     * @param category
     * @param freeShipping
     * @return ResponseEntity.ok(service.getByCategoryAndFree(category, freeShipping))
     */
    @GetMapping("/articles/filters")
    public ResponseEntity<List<ProdutoDto>> getByCategoryAndFree
            (@RequestParam String category, @RequestParam boolean freeShipping){
        return ResponseEntity.ok(service.getByCategoryAndFree(category, freeShipping));
    }

    /**
     * Retorna lista com todos os produtos disponíveis,
     * filtrados por categoria, frete grátis e ordenação escolhida.
     * @param category
     * @param freeShipping
     * @param order
     * @return ResponseEntity.ok(service.getByCategoryFreeOrdered(category, freeShipping, order))
     */
    @GetMapping("/articles/filters/order")
    public ResponseEntity<List<ProdutoDto>> getByCategoryFreeOrdered
            (@RequestParam String category, @RequestParam boolean freeShipping, @RequestParam int order) {
        return ResponseEntity.ok(service.getByCategoryFreeOrdered(category, freeShipping, order));
    }


    /**
     * Retorna lista com todos os produtos disponíveis,
     * filtrados por categoria e avaliação.
     * @param category
     * @param prestige
     * @return ResponseEntity.ok(service.getByCategoryAndPrestige(category, prestige))
     */
    @GetMapping("/articles/filters/1")
    public ResponseEntity<List<ProdutoDto>> getByCategoryAndPrestige
            (@RequestParam String category, @RequestParam String prestige){
        return ResponseEntity.ok(service.getByCategoryAndPrestige(category, prestige));
    }
}
