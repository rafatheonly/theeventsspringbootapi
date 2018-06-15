package com.theeventsspringboot.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;

import com.theeventsspringboot.entitys.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	Usuario findByEmail(String email);
}
