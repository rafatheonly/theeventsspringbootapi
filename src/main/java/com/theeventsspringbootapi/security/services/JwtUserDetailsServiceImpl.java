package com.theeventsspringbootapi.security.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.theeventsspringbootapi.entitys.Usuario;
import com.theeventsspringbootapi.security.jwt.JwtUserFactory;
import com.theeventsspringbootapi.services.UsuarioService;

@Service
public class JwtUserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UsuarioService usuarioService;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

		Usuario usuario = usuarioService.findByEmail(email);
		if (usuario == null) {
			throw new UsernameNotFoundException(String.format(
					"Nenhum usuário encontrado com o " + "nome de usuário referente a esse e-mail: '%s'.", email));
		} else {
			return JwtUserFactory.create(usuario);
		}
	}
}
