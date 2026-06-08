package com.healthsys.notificacoes.controller;

import com.healthsys.notificacoes.entity.NotificacaoEntity;
import com.healthsys.notificacoes.repository.NotificacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notificacao")
public class NotificacaoController {

    @Autowired
    private NotificacaoRepository notificacaoRepository;

    @GetMapping
    public ResponseEntity<List<NotificacaoEntity>> listar() {
        return ResponseEntity.ok(notificacaoRepository.findAll());
    }

    @GetMapping("/paciente/{pacienteId}")
    public ResponseEntity<List<NotificacaoEntity>> listarPorPaciente(@PathVariable Long pacienteId) {
        return ResponseEntity.ok(notificacaoRepository.findByPacienteIdOrderByDataHoraDesc(pacienteId));
    }
}
