package com.dh.meli.desafioSpring.controller;

import com.dh.meli.desafioSpring.dto.ProdutoDto;
import com.dh.meli.desafioSpring.model.Produto;
import com.dh.meli.desafioSpring.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ProdutoController {

    @Autowired
    private ProdutoService service;

    @PostMapping("/insert-articles-request")
    @ResponseStatus(HttpStatus.OK)
    public void cadastrarProduto(@RequestBody Produto produto){
        service.cadastrarProduto(produto);

    }

    @GetMapping("/articles")
    public ResponseEntity<List<ProdutoDto>> getAllProdutosDisponiveis() {
        return ResponseEntity.ok(service.getAllProdutosDisponiveis());
    }

    @GetMapping("/articles/") // gambiarra autorizada pelo Mauri!
    public ResponseEntity<List<ProdutoDto>> getAllCategoria(@RequestParam String category){
        return ResponseEntity.ok(service.getAllCategoria(category));
    }

    @GetMapping("/articles/all")
    public ResponseEntity<List<ProdutoDto>> getAll(){
        return ResponseEntity.ok(service.getAll());
    }



}
