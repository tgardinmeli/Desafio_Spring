package com.dh.meli.desafioSpring.controller;

import com.dh.meli.desafioSpring.dto.RequestProdutoDto;
import com.dh.meli.desafioSpring.dto.TicketDto;
import com.dh.meli.desafioSpring.service.CarrinhoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * Controller de carrinho.
 */
@RestController
@RequestMapping("/api/v1")
public class CarrinhoController {

    @Autowired
    private CarrinhoService carrinhoService;

    /**
     * Recebe lista de produtos para compra do usuário,
     * chama método processarCompra da camada de Service de Carrinho.
     * @param articlesPurchaseRequest
     * @return ResponseEntity<TicketDto>
     */
    @PostMapping("/purchase-request")
    public ResponseEntity<TicketDto> processarCompra
            (@Valid @RequestBody List<RequestProdutoDto> articlesPurchaseRequest){
        return ResponseEntity.ok(carrinhoService.processarCompra(articlesPurchaseRequest));
    }
}
