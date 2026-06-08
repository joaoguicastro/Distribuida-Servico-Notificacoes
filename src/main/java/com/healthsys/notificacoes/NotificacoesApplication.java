package com.healthsys.notificacoes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;

@SpringBootApplication
@EnableRabbit
public class NotificacoesApplication {
    public static void main(String[] args) {
        SpringApplication.run(NotificacoesApplication.class, args);
    }
}