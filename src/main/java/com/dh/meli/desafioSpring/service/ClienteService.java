package com.dh.meli.desafioSpring.service;

import com.dh.meli.desafioSpring.dto.ClienteDto;
import com.dh.meli.desafioSpring.model.Cliente;
import java.util.List;

public interface ClienteService {
    ClienteDto cadastrarCliente(Cliente cliente);
    List<ClienteDto> getAll();
    ClienteDto getClienteById(Long clienteId);
    List<ClienteDto> getByEstado(String estado);
    List<ClienteDto> getByNome(String nome);
}
