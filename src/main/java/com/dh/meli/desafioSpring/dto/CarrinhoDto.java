package com.dh.meli.desafioSpring.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CarrinhoDto { // recebe o payload do Usuario
    List<RequestProdutoDto> articlesPurchaseRequest = new ArrayList<RequestProdutoDto>();

}
