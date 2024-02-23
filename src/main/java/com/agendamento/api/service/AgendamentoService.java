package com.agendamento.api.service;

import com.agendamento.api.model.Agendamento;
import com.agendamento.api.model.Enum.Status;
import com.agendamento.api.repository.AgendamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AgendamentoService {

    @Autowired
    private AgendamentoRepository agendamentoRepository;

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

    public Agendamento atualizarAgendamento(Long id, Agendamento novoAgendamento) {
        Optional<Agendamento> optionalAgendamento = agendamentoRepository.findById(id);
        if (optionalAgendamento.isPresent()) {
            Agendamento agendamentoExistente = optionalAgendamento.get();
            agendamentoExistente.setId_client(novoAgendamento.getId_client());
            agendamentoExistente.setId_rota(novoAgendamento.getId_rota());
            agendamentoExistente.setStatus(novoAgendamento.getStatus());
            return agendamentoRepository.save(agendamentoExistente);
        } else {
            return null;
        }
    }


    public void deletarAgendamento(Long id) {
        agendamentoRepository.deleteById(id);
    }
}
