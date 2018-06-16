package com.theeventsspringbootapi.entitys;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
//import com.theeventsspringbootapi.enums.PerfilEnum;

@Entity
public class Usuario {

	@Id
	private Long id;
	private String nome;
	private String rg;
	private String email;
	private String senha;
	private String foto;
	private String perfil;
	private boolean ativo;

	@OneToMany(mappedBy = "usuario")
	private List<Evento> evento;

	@OneToMany(mappedBy = "usuario")
	private List<Tipoevento> tipoevento;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public String getPerfil() {
		return perfil;
	}

	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	@JsonIgnore
	public List<Evento> getEvento() {
		return evento;
	}

	public void setEvento(List<Evento> evento) {
		this.evento = evento;
	}

	@JsonIgnore
	public List<Tipoevento> getTipoevento() {
		return tipoevento;
	}

	public void setTipoevento(List<Tipoevento> tipoevento) {
		this.tipoevento = tipoevento;
	}

}
