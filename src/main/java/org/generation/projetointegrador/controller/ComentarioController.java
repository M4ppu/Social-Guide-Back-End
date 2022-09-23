package org.generation.projetointegrador.controller;

import org.generation.projetointegrador.model.Comentario;
import org.generation.projetointegrador.service.ComentarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/postagens/comentarios")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ComentarioController {
	
	@Autowired
	private ComentarioService comentarioService;
	
	@PostMapping("/{postagem}/{usuario}")
	private void findById(@PathVariable Long postagem, @PathVariable Long usuario, @RequestBody Comentario comentarios){
		comentarioService.adicionarComentario(usuario, postagem, comentarios);
	}
	
	@PutMapping("/{postagem}/{usuario}")
	private void edit(@PathVariable Long postagem, @PathVariable Long usuario, @RequestBody Comentario comentarios){
		comentarioService.editarComentario(usuario, postagem, comentarios);
	}
	
	@DeleteMapping("/{postagem}/{usuario}")
	public void delete(@PathVariable Long postagem, @PathVariable Long usuario){
		comentarioService.removerComentario(postagem, usuario);
	}
}