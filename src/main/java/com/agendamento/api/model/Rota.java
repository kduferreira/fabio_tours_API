    package com.agendamento.api.model;

    import com.fasterxml.jackson.annotation.JsonFormat;
    import jakarta.annotation.Nonnull;
    import jakarta.persistence.*;
    import lombok.Data;

    import java.time.LocalDate;
    import java.time.LocalDateTime;
    import java.util.List;

    @Entity
    @Data
    public class Rota {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id_rota;

        private String destino;
        @JsonFormat(pattern = "yyyy-MM-dd")
        private LocalDate data;


        private String onibus;

        private List<String> cidades;

        @OneToMany(mappedBy = "rota_id") // Uma rota pode ter vários agendamentos
        private List<Agendamento> agendados;

    }
