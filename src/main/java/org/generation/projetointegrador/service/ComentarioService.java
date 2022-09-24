package org.generation.projetointegrador.service;

import org.generation.projetointegrador.model.Comentario;
import org.generation.projetointegrador.model.ComentarioModel;
import org.generation.projetointegrador.model.PostagensModel;
import org.generation.projetointegrador.model.UsuarioModel;
import org.generation.projetointegrador.repository.ComentarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ComentarioService {
	
	@Autowired
	private ComentarioRepository repository;
	
	public void removerComentario(Long postagem, Long usuario) {
		repository.deletar(postagem, usuario);
	}
}