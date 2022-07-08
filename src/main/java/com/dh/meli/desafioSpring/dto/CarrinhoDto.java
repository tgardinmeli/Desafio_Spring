package com.dh.meli.desafioSpring.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * Recebe o payload do usuário.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CarrinhoDto { 
    List<RequestProdutoDto> articlesPurchaseRequest = new ArrayList<RequestProdutoDto>();

}
