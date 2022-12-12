package com.example.oficinaco.jpa.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.oficinaco.jpa.entidade.Categoria;


@Repository
public interface CategoriaDao extends JpaRepository<Categoria, Integer>{
	@Query(nativeQuery = true, value = "select * from categoria where id = :id")
	Categoria findbyCategoria(@Param("id") Integer id);

	@Query(nativeQuery = true, value = "select * from categoria c where lower(c.nome) like lower(:nome)")
	List<Categoria> listarPorNome(@Param("nome") String nome);
}
