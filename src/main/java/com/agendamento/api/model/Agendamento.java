package com.agendamento.api.model;

import com.agendamento.api.model.Enum.Status;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Agendamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private Status status;

    private Integer poltrona;


    private Long rota_id;



    private Long client_id;

    // Getters e setters


}
