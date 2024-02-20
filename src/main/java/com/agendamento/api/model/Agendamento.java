package com.agendamento.api.model;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Agendamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String status;




//    @OneToOne
//    @JoinColumn(name = "id_client")
//    private Client client;

    private Long id_rota;

    private Long id_client;


}
