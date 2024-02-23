package com.agendamento.api.controller;

import com.agendamento.api.model.Agendamento;
import com.agendamento.api.service.AgendamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/agendamentos")
public class AgendamentoController {

    @Autowired
    private AgendamentoService agendamentoService;

    @PostMapping
    public ResponseEntity<Agendamento> salvar(@RequestBody Agendamento agendamento) {
        Agendamento novoAgendamento = agendamentoService.salvarAgendamento(agendamento);
        return ResponseEntity.ok(novoAgendamento);
    }

    @GetMapping
    public ResponseEntity<List<Agendamento>> buscarTudo() {
        List<Agendamento> agendamentos = agendamentoService.buscarTodosAgendamentos();
        return ResponseEntity.ok(agendamentos);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Agendamento> atualizar(@PathVariable Long id, @RequestBody Agendamento novoAgendamento) {
        Agendamento agendamentoAtualizado = agendamentoService.atualizarAgendamento(id, novoAgendamento);
        if (agendamentoAtualizado != null) {
            return ResponseEntity.ok(agendamentoAtualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        agendamentoService.deletarAgendamento(id);
        return ResponseEntity.noContent().build();
    }
}
