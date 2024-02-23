package com.agendamento.api.repository;

import com.agendamento.api.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
    Client findByCpf(String cpf);

    Client findByName(String name);
}
