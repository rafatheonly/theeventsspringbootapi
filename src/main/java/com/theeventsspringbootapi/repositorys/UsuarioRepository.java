package com.theeventsspringbootapi.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;

import com.theeventsspringbootapi.entitys.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	Usuario findByEmail(String email);
}
