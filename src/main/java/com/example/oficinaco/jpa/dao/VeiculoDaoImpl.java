package com.example.oficinaco.jpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.oficinaco.jpa.entidade.Pessoa;
import com.example.oficinaco.jpa.entidade.Veiculo;

@Repository
public class VeiculoDaoImpl {

	@Autowired
	private EntityManager em;
	
	public List<Veiculo> listarPorPlaca(String placa){
		String sql = "select * from veiculo p where lower(p.placa) like lower(:placa)";

		
		Query query = em.createNativeQuery(sql, Veiculo.class);
		query.setParameter("placa", placa);
		return query.getResultList();
	}
	

}
