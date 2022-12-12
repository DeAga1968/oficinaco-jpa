package com.example.oficinaco.jpa.entidade;

public enum TipoOrdemServico {

	ORCAMENTO("Orçamento"),
	ORDEM("Ordem Serviço"),
	EMANDAMENTO("Em Andamento"),
	CONCLUIDA("Concluida"),
	CANCELADA("Cancelada");

	private String descricao;
	
	TipoOrdemServico(String descricao) {
		this.descricao = descricao;
	}

	
//teste
	public String getDescricao() {
		return descricao;
	}

	

}