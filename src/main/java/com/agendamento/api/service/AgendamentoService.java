package com.agendamento.api.service;

import com.agendamento.api.model.Agendamento;
import com.agendamento.api.model.Client;
import com.agendamento.api.model.Rota;
import com.agendamento.api.model.Enum.Status;
import com.agendamento.api.repository.AgendamentoRepository;
import com.agendamento.api.repository.RotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class AgendamentoService {

    @Autowired
    private AgendamentoRepository agendamentoRepository;
    @Autowired
    private RotaService rotaService;
    @Autowired
    private ClientService clientService;
    @Autowired
    private RotaRepository rotaRepository;
    public Agendamento salvarAgendamento(Agendamento agendamento) {
        agendamento.setStatus(Status.PENDENTE);
        return agendamentoRepository.save(agendamento);
    }

    public List<Agendamento> buscarTodosAgendamentos() {
        return agendamentoRepository.findAll();
    }

    public Agendamento buscarAgendamentoPorId(Long id) {
        Optional<Agendamento> optionalAgendamento = agendamentoRepository.findById(id);
        return optionalAgendamento.orElse(null);
    }
    public List<Client> buscarClientesPorRota(String destino) {
        Rota rota = rotaRepository.findByDestino(destino);
        List<Client> clientes = new ArrayList<>();

        if (rota != null) {
            List<Agendamento> agendamentos = rota.getAgendados();
            List<Long> idClientes = agendamentos.stream()
                    .map(Agendamento::getClient_id)
                    .collect(Collectors.toList());

            clientes = idClientes.stream()
                    .map(clientService::buscarClientePorId)
                    .filter(Optional::isPresent)
                    .map(Optional::get)
                    .collect(Collectors.toList());

            // Ordenar os clientes com base na ordem das cidades na rota
            clientes.sort(Comparator.comparing(cliente -> {
                int index = rota.getCidades().indexOf(cliente.getCidade());
                return index == -1 ? Integer.MAX_VALUE : index;
            }));
        }

        return clientes;
    }


//    public Agendamento atualizarAgendamento(Long id, Agendamento novoAgendamento) {
//        Optional<Agendamento> optionalAgendamento = agendamentoRepository.findById(id);
//        if (optionalAgendamento.isPresent()) {
//            Agendamento agendamentoExistente = optionalAgendamento.get();
//            agendamentoExistente.setIdClient(novoAgendamento.getClient().getId_client());
//            agendamentoExistente.setIdRota(novoAgendamento.getIdRota());
//            agendamentoExistente.setStatus(novoAgendamento.getStatus());
//            return agendamentoRepository.save(agendamentoExistente);
//        } else {
//            return null;
//        }
//    }


    public void deletarAgendamento(Long id) {
        agendamentoRepository.deleteById(id);
    }
}
