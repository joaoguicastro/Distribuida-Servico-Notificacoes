package com.healthsys.notificacoes.repository;

import com.healthsys.notificacoes.entity.NotificacaoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NotificacaoRepository extends JpaRepository<NotificacaoEntity, Long> {
    List<NotificacaoEntity> findByPacienteIdOrderByDataHoraDesc(Long pacienteId);
}
