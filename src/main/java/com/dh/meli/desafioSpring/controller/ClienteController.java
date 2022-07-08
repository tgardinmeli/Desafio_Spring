package com.dh.meli.desafioSpring.controller;

import com.dh.meli.desafioSpring.dto.ClienteDto;
import com.dh.meli.desafioSpring.dto.ProdutoDto;
import com.dh.meli.desafioSpring.model.Cliente;
import com.dh.meli.desafioSpring.model.Produto;
import com.dh.meli.desafioSpring.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/api/v1")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping("/insert-client-request")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ClienteDto> cadastrarCliente(@RequestBody @Valid Cliente cliente){
        return ResponseEntity.ok(clienteService.cadastrarCliente(cliente));
    }

    @GetMapping("/clientes")
    public ResponseEntity<List<ClienteDto>> getAllClientes() {
        return ResponseEntity.ok(clienteService.getAll());
    }

    @GetMapping("/clientes/id/{id}")
    public ResponseEntity<ClienteDto> getClienteById(@PathVariable String id) {
        Long idLong = Long.parseLong(id);
        return ResponseEntity.ok(clienteService.getClienteById(idLong));
    }

    @GetMapping("/clientes/estado/{estado}")
    public ResponseEntity<List<ClienteDto>> getClienteByEstado(@PathVariable String estado) {
        return ResponseEntity.ok(clienteService.getByEstado(estado));
    }

    @GetMapping("/clientes/nome/{nome}")
    public ResponseEntity<List<ClienteDto>> getClienteByNome(@PathVariable String nome) {
        return ResponseEntity.ok(clienteService.getByNome(nome));
    }
}
