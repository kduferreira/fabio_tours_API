package com.agendamento.api.service;

import com.agendamento.api.model.Rota;
import com.agendamento.api.repository.RotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RotaService {

    @Autowired
    private RotaRepository rotaRepository;

    public Rota salvarRota(Rota rota) {
        return rotaRepository.save(rota);
    }

    public List<Rota> buscarTodasRotas() {
        return rotaRepository.findAll();
    }

    public Rota buscarRotaPorId(Long id) {
        Optional<Rota> optionalRota = rotaRepository.findById(id);
        return optionalRota.orElse(null);
    }
    public Rota buscarRotaPorNome(String destino) {
        return rotaRepository.findByDestino(destino);
    }
    public Rota atualizarRota(Long id, Rota novaRota) {
        Optional<Rota> optionalRota = rotaRepository.findById(id);
        if (optionalRota.isPresent()) {
            Rota rotaExistente = optionalRota.get();
            rotaExistente.setDestino(novaRota.getDestino());
            rotaExistente.setData(novaRota.getData());
            return rotaRepository.save(rotaExistente);
        } else {
            return null;
        }
    }

    public void deletarRota(Long id) {
        rotaRepository.deleteById(id);
    }
}
