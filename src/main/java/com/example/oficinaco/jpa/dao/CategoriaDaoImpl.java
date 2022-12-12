package com.example.oficinaco.jpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.oficinaco.jpa.entidade.Categoria;


@Repository
public class CategoriaDaoImpl {

	@Autowired
	private EntityManager em;
	
	public List<Categoria> listarPorNome(String nome){
		String sql = "select * from categoria c where lower(c.nome) like lower(:nome)";

		Query query = em.createNativeQuery(sql, Categoria.class);
		query.setParameter("nome", nome);
		return query.getResultList();
	}
	

}
