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
    private Status status;
    private Integer poltrona;

    private Long id_rota;

    private Long id_client;

//    @OneToOne
//    @JoinColumn(name = "id_client")
//    private Client client;


}
