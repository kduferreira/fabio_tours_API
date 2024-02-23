package com.agendamento.api.service;

import com.agendamento.api.model.Client;
import com.agendamento.api.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public Client salvarCliente(Client cliente) {
        return clientRepository.save(cliente);
    }

    public List<Client> buscarTodosClientes() {
        return clientRepository.findAll();
    }

    public Optional<Client> buscarClientePorId(Long id) {
        return clientRepository.findById(id);
    }

    public Client buscarClientePorCpf(String cpf) {
        return clientRepository.findByCpf(cpf);
    }

    public Client buscarClientePorNome(String nome) {
        return clientRepository.findByName(nome);
    }

    public Client atualizarCliente(Long id, Client clienteNovo) {
        Optional<Client> clienteOptional = clientRepository.findById(id);
        if (clienteOptional.isPresent()) {
            Client clienteExistente = clienteOptional.get();
            clienteExistente.setName(clienteNovo.getName());
            clienteExistente.setEndereco(clienteNovo.getEndereco());
            clienteExistente.setCpf(clienteNovo.getCpf());
            return clientRepository.save(clienteExistente);
        } else {
            throw new RuntimeException("Cliente não encontrado");
        }
    }

    public void deletarCliente(Long id) {
        Optional<Client> clienteOptional = clientRepository.findById(id);
        if (clienteOptional.isPresent()) {
            clientRepository.deleteById(id);
        } else {
            throw new RuntimeException("Cliente não encontrado");
        }
    }
}
