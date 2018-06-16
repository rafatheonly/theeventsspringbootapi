package com.theeventsspringbootapi.services;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.theeventsspringbootapi.entitys.Usuario;

@Component
public interface UsuarioService {

	Usuario findByEmail(String email);

	Usuario createOrUpdate(Usuario usuario);

	Usuario findById(Long id);

	void delete(Long id);

	// PASSA A pagina Q SE QUER E A quantidade DE REGISTROS
	Page<Usuario> findAll(int pagina, int quantidade);
}
