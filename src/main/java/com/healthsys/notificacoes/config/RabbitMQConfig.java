package com.healthsys.notificacoes.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    public static final String EXCHANGE    = "triagem.exchange";
    public static final String QUEUE       = "notificacao.queue";
    public static final String ROUTING_KEY = "triagem.routing";

    @Bean
    public TopicExchange triagemExchange() {
        return new TopicExchange(EXCHANGE);
    }

    @Bean
    public Queue notificacaoQueue() {
        return new Queue(QUEUE, true);
    }

    @Bean
    public Binding binding() {
        return BindingBuilder
                .bind(notificacaoQueue())
                .to(triagemExchange())
                .with(ROUTING_KEY);
    }

    @Bean
    public Jackson2JsonMessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }
}