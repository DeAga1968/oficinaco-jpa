package com.example.oficinaco.jpa.jsf;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.SessionScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.oficinaco.jpa.dao.CategoriaDao;
import com.example.oficinaco.jpa.entidade.Categoria;

@Component
@SessionScoped
public class CategoriaControl {
	
	@Autowired
	private CategoriaDao categoriaDao;
	
	private Categoria categoria = new Categoria();
	
	private List<Categoria> categorias = new ArrayList<>();
	
	@PostConstruct
	public void init() {
		listar();
	}
	
	public void salvar() {
		categoriaDao.save(categoria);
		categoria = new Categoria();
		listar();
	}
	
	public void listar() {
		categorias = categoriaDao.findAll();
	}
	
	public void excluir(Integer id) {
		categoriaDao.deleteById(id);
		listar();
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public List<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}

	
}














