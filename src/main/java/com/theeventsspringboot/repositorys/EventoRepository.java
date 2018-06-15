package com.theeventsspringboot.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;

import com.theeventsspringboot.entitys.Evento;

public interface EventoRepository extends JpaRepository<Evento, Long> {

}
