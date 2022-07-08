package com.dh.meli.desafioSpring.service;

import com.dh.meli.desafioSpring.dto.ClienteDto;
import com.dh.meli.desafioSpring.dto.ProdutoDto;
import com.dh.meli.desafioSpring.model.Cliente;
import com.dh.meli.desafioSpring.model.Produto;
import com.dh.meli.desafioSpring.repository.ClienteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class ClienteServiceImp implements ClienteService{
    // metodos que existem na interface:
    //    ClienteDto cadastrarCliente(Cliente cliente);
    //    List<ClienteDto> getAll();
    //    List<ClienteDto> getClienteById(Long clienteId);
    //    List<ClienteDto> getByEstado(String estado);
    //    List<ClienteDto> getByNome(String nome);

    @Autowired
    private ClienteRepo clienteRepo;



    @Override
    public List<ClienteDto> getAll(){
        List<ClienteDto> listaClienteDto = clienteRepo.getAll()
                .stream().map(ClienteDto::new)
                .collect(Collectors.toList());
        return listaClienteDto;
    }

    @Override
    public ClienteDto cadastrarCliente(Cliente cliente) {
        clienteRepo.cadastrarCliente(cliente);
        ClienteDto clienteDto = new ClienteDto(cliente);
        return clienteDto;
    }

    @Override
    public ClienteDto getClienteById(Long clienteId) {
            List<Cliente> listaCliente = clienteRepo.getAll();
            return  listaCliente.stream()
                    .filter(c-> c.getClienteID().equals(clienteId))
                    .map(ClienteDto::new)
                    .findFirst()
                    .get();
    }

    @Override
    public List<ClienteDto> getByEstado(String estado) {
        List<ClienteDto> clientesDto = clienteRepo.getAll()
                .stream().filter(c -> c.getEstado().toLowerCase().contains(estado.toLowerCase()))
                .map(ClienteDto::new).collect(Collectors.toList());

        return clientesDto;
    }

    @Override
    public List<ClienteDto> getByNome(String nome) {
        List<ClienteDto> clientesDto = clienteRepo.getAll()
                .stream().filter(c -> c.getNome().toLowerCase().contains(nome.toLowerCase()))
                .map(ClienteDto::new).collect(Collectors.toList());

        return clientesDto;
    }
}
