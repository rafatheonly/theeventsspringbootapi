package com.theeventsspringbootapi.security.jwt;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.theeventsspringbootapi.entitys.Usuario;
import com.theeventsspringbootapi.enums.PerfilEnum;

public class JwtUserFactory {

	private JwtUserFactory() {
	}

	/**
	 * METODO Q CONVERTE E GERA O JwtUser C/ BASE NOS DADOS DE UM USUARIO
	 * @param usuario
	 * @return UM JwtUser C/ OS DADOS DO USUARIO
	 */
	public static JwtUser create(Usuario usuario) {
		return new JwtUser(usuario.getId(), usuario.getEmail(), usuario.getSenha(),
				mapToGrantedAuthorities(usuario.getPerfil()));
	}

	/**
	 * METODO Q SERVE P/ CONVERTER O PERFIL DO USUARIO P/ O FORMATO UTILIZADO PELO SPRING SECURITY
	 * @param perfilEnum
	 * @return O PERFIL
	 */
	private static List<GrantedAuthority> mapToGrantedAuthorities(String perfilEnum) {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority(perfilEnum.toString()));
		return authorities;
	}
}
