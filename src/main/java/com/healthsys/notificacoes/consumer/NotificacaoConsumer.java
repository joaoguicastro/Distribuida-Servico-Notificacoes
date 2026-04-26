package com.healthsys.notificacoes.consumer;

import com.healthsys.notificacoes.event.TriagemRealizadaEvent;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class NotificacaoConsumer {

    @RabbitListener(queues = "notificacao.queue")
    public void receberEvento(TriagemRealizadaEvent event) {
        System.out.println("📢 NOTIFICAÇÃO DISPARADA");
        System.out.println("Paciente: " + event.nome());
        System.out.println("Risco: " + event.nivelRisco());
    }
}
