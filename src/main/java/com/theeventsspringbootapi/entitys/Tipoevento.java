package com.theeventsspringbootapi.entitys;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Tipoevento {

	@Id
	private Long id;

	private String descricao_tipo_evento;

	@OneToMany(mappedBy = "tipoevento")
	private List<Evento> evento;

	@ManyToOne
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao_tipo_evento() {
		return descricao_tipo_evento;
	}

	public void setDescricao_tipo_evento(String descricao_tipo_evento) {
		this.descricao_tipo_evento = descricao_tipo_evento;
	}

	@JsonIgnore
	public List<Evento> getEvento() {
		return evento;
	}

	public void setEvento(List<Evento> evento) {
		this.evento = evento;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
