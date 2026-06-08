package com.healthsys.notificacoes.consumer;

import com.healthsys.notificacoes.entity.NotificacaoEntity;
import com.healthsys.notificacoes.event.TriagemRealizadaEvent;
import com.healthsys.notificacoes.repository.NotificacaoRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class NotificacaoConsumer {

    @Autowired
    private NotificacaoRepository notificacaoRepository;

    @RabbitListener(queues = "notificacao.queue")
    public void receberEvento(TriagemRealizadaEvent event) {
        System.out.println("📢 NOTIFICAÇÃO DISPARADA - Paciente: " + event.nome() + " | Risco: " + event.nivelRisco());

        String mensagem = String.format(
                "Triagem realizada para %s. Nível de risco: %s.",
                event.nome(), event.nivelRisco()
        );

        NotificacaoEntity notificacao = NotificacaoEntity.builder()
                .pacienteId(event.pacienteId())
                .nomePaciente(event.nome())
                .nivelRisco(event.nivelRisco())
                .mensagem(mensagem)
                .dataHora(LocalDateTime.now())
                .build();

        notificacaoRepository.save(notificacao);
    }
}
