package com.agendamento.api.controller;

import com.agendamento.api.model.Rota;
import com.agendamento.api.service.RotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rotas")
public class RotaController {

    @Autowired
    private RotaService rotaService;

    @PostMapping
    public ResponseEntity<Rota> salvar(@RequestBody Rota rota) {
        Rota novaRota = rotaService.salvarRota(rota);
        return ResponseEntity.ok(novaRota);
    }

    @GetMapping
    public ResponseEntity<List<Rota>> buscarTudo() {
        List<Rota> rotas = rotaService.buscarTodasRotas();
        return ResponseEntity.ok(rotas);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Rota> atualizar(@PathVariable Long id, @RequestBody Rota novaRota) {
        Rota rotaAtualizada = rotaService.atualizarRota(id, novaRota);
        if (rotaAtualizada != null) {
            return ResponseEntity.ok(rotaAtualizada);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        rotaService.deletarRota(id);
        return ResponseEntity.noContent().build();
    }
}
