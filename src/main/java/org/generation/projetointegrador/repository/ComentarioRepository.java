package org.generation.projetointegrador.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.generation.projetointegrador.model.ComentarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface ComentarioRepository extends JpaRepository<ComentarioModel, Long>{
	public List<ComentarioModel> findAllByComentariosContainingIgnoreCase(@Param("comentarios") String comentarios);
	
	@Modifying
	@Query("delete from ComentarioModel p where p.postagem = :postagem and p.usuario = :usuario")
	Integer deletar(@Param("postagem") Long postagem, @Param("usuario") Long usuario);
	
	@Modifying
	@Query("update ComentarioModel p set comentarios = :comentarios where p.postagem = :postagem and p.usuario = :usuario")
	Integer editar(@Param("comentarios") String comentarios, @Param("postagem") Long postagem, @Param("usuario") Long usuario);

	// public Object findByPostagem(Long postagem);
	
	public List<ComentarioModel> findByPostagem(Long postagem);
}