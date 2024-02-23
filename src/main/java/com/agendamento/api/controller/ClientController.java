package com.agendamento.api.controller;

import com.agendamento.api.model.Client;
import com.agendamento.api.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @PostMapping
    public ResponseEntity<Client> salvar(@RequestBody Client client) {
        Client novoCliente = clientService.salvarCliente(client);
        return ResponseEntity.ok(novoCliente);
    }

    @GetMapping
    public ResponseEntity<List<Client>> buscarTodos() {
        List<Client> clientes = clientService.buscarTodosClientes();
        return ResponseEntity.ok(clientes);
    }

    @GetMapping("/cpf/{cpf}")
    public ResponseEntity<Client> buscarPorCPF(@PathVariable String cpf) {
        Client cliente = clientService.buscarClientePorCpf(cpf);
        if (cliente != null) {
            return ResponseEntity.ok(cliente);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity<Client> buscarPorNome(@PathVariable String nome) {
        Client cliente = clientService.buscarClientePorNome(nome);
        if (cliente != null) {
            return ResponseEntity.ok(cliente);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Client> atualizar(@PathVariable Long id, @RequestBody Client clientNovo) {
        Client clienteAtualizado = clientService.atualizarCliente(id, clientNovo);
        return ResponseEntity.ok(clienteAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        clientService.deletarCliente(id);
        return ResponseEntity.noContent().build();
    }
}
