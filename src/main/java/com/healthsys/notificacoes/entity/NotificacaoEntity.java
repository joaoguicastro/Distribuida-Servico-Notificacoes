package com.healthsys.notificacoes.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "tb_notificacoes")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NotificacaoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "paciente_id")
    private Long pacienteId;

    @Column(name = "nome_paciente")
    private String nomePaciente;

    @Column(name = "nivel_risco")
    private String nivelRisco;

    @Column(name = "mensagem", length = 500)
    private String mensagem;

    @Column(name = "data_hora")
    private LocalDateTime dataHora;
}
