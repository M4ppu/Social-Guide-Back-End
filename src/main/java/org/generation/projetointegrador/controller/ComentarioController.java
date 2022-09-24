package org.generation.projetointegrador.controller;

import java.util.List;
import java.util.Optional;

import org.generation.projetointegrador.model.Comentario;
import org.generation.projetointegrador.model.ComentarioModel;
import org.generation.projetointegrador.model.PostagensModel;
import org.generation.projetointegrador.repository.ComentarioRepository;
import org.generation.projetointegrador.service.ComentarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
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
	
	@Autowired
	private ComentarioRepository repository;
	
	
	@PostMapping
	public ResponseEntity<ComentarioModel> post(@RequestBody ComentarioModel comentarios){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(comentarios));
	}
	
	//@PutMapping
	//private void edit(@RequestBody ComentarioModel comentarios){
	//	comentarioService.editarComentario(comentarios);
	//}
	
	@PutMapping
	public ResponseEntity<ComentarioModel> put (@RequestBody ComentarioModel comentario){
		return ResponseEntity.ok().body(repository.save(comentario));
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		repository.deleteById(id);
	}
	
	
	@GetMapping("/{id}")
    public Optional<ComentarioModel> getById(@PathVariable Long id) {
        return repository.findById(id);
    }
}