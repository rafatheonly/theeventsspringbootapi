package com.theeventsspringboot.services.implementacoes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.theeventsspringboot.services.UsuarioService;
import com.theeventsspringboot.entitys.Usuario;
import com.theeventsspringboot.repositorys.UsuarioRepository;

@Service
public class UsuarioServiceImplementa implements UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	public Usuario findByEmail(String email) {
		return this.usuarioRepository.findByEmail(email);
	}

	public Usuario createOrUpdate(Usuario usuario) {
		return this.usuarioRepository.save(usuario);
	}

	public Usuario findById(Long id) {
		return this.usuarioRepository.getOne(id);
	}

	public void delete(Long id) {
		this.usuarioRepository.getOne(id);

	}

	public Page<Usuario> findAll(int pagina, int quantidade) {
		PageRequest pageRequest = PageRequest.of(pagina, quantidade);
		return this.usuarioRepository.findAll(pageRequest);
	}
}
