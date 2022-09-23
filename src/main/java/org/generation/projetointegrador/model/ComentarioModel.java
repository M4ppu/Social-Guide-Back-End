package org.generation.projetointegrador.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table (name = "comentarios")
public class ComentarioModel {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY) 
	private Long id;
	
	private String comentarios;
	
	@JoinColumn(name = "id_postagem")
	@NotNull(message = "O atributo id_postagem é Obrigatório e não pode utilizar espaços em branco!")
	private Long postagem;

	@JoinColumn(name = "id_usuario")
	@NotNull(message = "O atributo id_usuario é Obrigatório e não pode utilizar espaços em branco!")
	private Long usuario;	

		

	public ComentarioModel(String comentarios,
			@NotNull(message = "O atributo id_postagem é Obrigatório e não pode utilizar espaços em branco!") Long postagem,
			@NotNull(message = "O atributo id_usuario é Obrigatório e não pode utilizar espaços em branco!") Long usuario) {
		this.comentarios = comentarios;
		this.postagem = postagem;
		this.usuario = usuario;
	}

	public ComentarioModel() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getComentarios() {
		return comentarios;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}

	public Long getPostagem() {
		return postagem;
	}

	public void setPostagem(Long postagem) {
		this.postagem = postagem;
	}

	public Long getUsuario() {
		return usuario;
	}

	public void setUsuario(Long usuario) {
		this.usuario = usuario;
	}
}