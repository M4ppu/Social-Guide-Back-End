package org.generation.projetointegrador.service;

import org.generation.projetointegrador.model.Comentario;
import org.generation.projetointegrador.model.ComentarioModel;
import org.generation.projetointegrador.model.PostagensLikeModel;
import org.generation.projetointegrador.repository.ComentarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ComentarioService {
	
	@Autowired
	private ComentarioRepository repository;
	
	public void adicionarComentario(Long postagem, Long usuario, Comentario comentarios) {
		 repository.save(new ComentarioModel(comentarios.getComentarios(), usuario, postagem));				
	}
	
	public void editarComentario(Long postagem, Long usuario, Comentario comentarios) {
		 repository.editar(comentarios.getComentarios(), usuario, postagem);				
	}
	
	public void removerComentario(Long postagem, Long usuario) {
		repository.deletar(postagem, usuario);
	}
}