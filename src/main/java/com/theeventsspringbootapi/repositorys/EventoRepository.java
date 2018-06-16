package com.theeventsspringbootapi.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;

import com.theeventsspringbootapi.entitys.Evento;

public interface EventoRepository extends JpaRepository<Evento, Long> {

}
