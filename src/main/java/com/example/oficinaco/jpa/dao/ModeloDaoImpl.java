package com.example.oficinaco.jpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.oficinaco.jpa.entidade.Modelo;
import com.example.oficinaco.jpa.entidade.Pessoa;

@Repository
public class ModeloDaoImpl {

	@Autowired
	private EntityManager em;
	
	public List<Modelo> listarPorNome(String nome){
		String sql = "select * from modelo p where lower(p.nome) like lower(:nome)";

		Query query = em.createNativeQuery(sql, Modelo.class);
		query.setParameter("nome", nome);
		return query.getResultList();
	}
	

}
