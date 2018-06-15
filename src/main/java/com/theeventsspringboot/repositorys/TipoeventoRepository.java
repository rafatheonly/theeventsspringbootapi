package com.theeventsspringboot.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;

import com.theeventsspringboot.entitys.Tipoevento;

public interface TipoeventoRepository extends JpaRepository<Tipoevento, Long> {

}
