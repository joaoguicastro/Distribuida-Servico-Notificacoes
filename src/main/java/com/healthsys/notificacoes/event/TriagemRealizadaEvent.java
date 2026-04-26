package com.healthsys.notificacoes.event;

public record TriagemRealizadaEvent(
        Long pacienteId,
        String nome,
        String nivelRisco
) {
}
