package org.generation.projetointegrador.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table (name = "comentarios")
public class ComentarioModel {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY) 
	private Long id;
	
	private String comentarios;

	@ManyToOne
	@JsonIgnoreProperties("Postagens")
	private UsuarioModel usuario;	
	
	@ManyToOne
	@JsonIgnoreProperties("Usuario")
	private PostagensModel postagem;

		

	public ComentarioModel(String comentarios,
			@NotNull(message = "O atributo id_postagem é Obrigatório e não pode utilizar espaços em branco!") PostagensModel postagem,
			@NotNull(message = "O atributo id_usuario é Obrigatório e não pode utilizar espaços em branco!") UsuarioModel usuario) {
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

	public UsuarioModel getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioModel usuario) {
		this.usuario = usuario;
	}

	public PostagensModel getPostagem() {
		return postagem;
	}

	public void setPostagem(PostagensModel postagem) {
		this.postagem = postagem;
	}

	
	
}