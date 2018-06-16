package com.theeventsspringbootapi.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;

import com.theeventsspringbootapi.entitys.Tipoevento;

public interface TipoeventoRepository extends JpaRepository<Tipoevento, Long> {

}
