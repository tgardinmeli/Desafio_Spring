package com.dh.meli.desafioSpring.controller;

import com.dh.meli.desafioSpring.dto.ProdutoDto;
import com.dh.meli.desafioSpring.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ProdutoController {

    @Autowired
    private ProdutoService service;

//
//    public ResponseEntity<ProdutoDto>(){
//        List<ProdutoDto> lista = service.get
//        return
//    }

    @GetMapping
    public ResponseEntity<List<ProdutoDto>> getAllProdutosDisponiveis() {

        return null;
    }

}
