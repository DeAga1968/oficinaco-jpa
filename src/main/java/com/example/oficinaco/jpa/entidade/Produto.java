package com.example.oficinaco.jpa.entidade;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String nome;
	
	private int categoria;
	
	private int quantidade;
	
	private int estoqueMin;
	
	private BigDecimal precoVenda;
	
	private BigDecimal precoAcusto;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public int getCategoria() {
		return categoria;
	}

	public void setCategoria(int categoria) {
		this.categoria = categoria;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	public int getQuantidade() {
		return quantidade;
	}

	public void setEstoqueMin(int estoqueMin) {
		this.estoqueMin = estoqueMin;
	}
	
	public int getEstoqueMin() {
		return estoqueMin;
	}

	public void setPrecoVenda(BigDecimal precoVenda) {
		this.precoVenda = precoVenda;
	}
	
	public BigDecimal getPrecoVenda() {
		return precoVenda;
	}

	public void setPrecoAcusto(BigDecimal precoAcusto) {
		this.precoAcusto = precoVenda;
	}
	
	public BigDecimal getPrecoAcusto() {
		return precoAcusto;
	}
	
	@Override
	public String toString() {
		return String.format("%s - %s", nome, precoVenda);
	}
}
