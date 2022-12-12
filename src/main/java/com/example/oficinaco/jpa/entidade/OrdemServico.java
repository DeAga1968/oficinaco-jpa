package com.example.oficinaco.jpa.entidade;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class OrdemServico {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne(optional = false)
	private Pessoa cliente;
	
	@ManyToOne(optional = false)
	private Pessoa funcionario;
	
	@ManyToOne(optional = false)
	private Veiculo veiculo;
	
	@OneToMany(cascade=CascadeType.PERSIST)
	@JoinColumn(name="ordem_servico_id")
	private List<OrdemServicoServico> servicos = new ArrayList<>();

	@OneToMany(cascade=CascadeType.PERSIST)
	@JoinColumn(name="ordem_servico_id")
	private List<OrdemServicoProduto> produtos = new ArrayList<>();
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataOrcamento;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataInicio;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataEstimativa;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataEntrega;
	
	private BigDecimal desconto;
	
	private TipoOrdemServico tipoOrdemServico;
	
	private String Tipo;

	public BigDecimal getTotalServicos() {
		BigDecimal vlr = BigDecimal.ZERO;
		for(OrdemServicoServico oss : servicos) {
			vlr = vlr.add(oss.getTotal());
		}
		return vlr;
	}

	public BigDecimal getTotalProdutos() {
		BigDecimal vlr = BigDecimal.ZERO;
		for(OrdemServicoProduto oss : produtos) {
			vlr = vlr.add(oss.getTotal());
		}
		return vlr;
	}
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Pessoa getCliente() {
		return cliente;
	}

	public void setCliente(Pessoa cliente) {
		this.cliente = cliente;
	}

	public Pessoa getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Pessoa funcionario) {
		this.funcionario = funcionario;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	

	public Date getDataOrcamento() {
		return dataOrcamento;
	}

	public void setDataOrcamento(Date dataOrcamento) {
		this.dataOrcamento = dataOrcamento;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataEstimativa() {
		return dataEstimativa;
	}

	public void setDataEstimativa(Date dataEstimativa) {
		this.dataEstimativa = dataEstimativa;
	}

	public Date getDataEntrega() {
		return dataEntrega;
	}

	public void setDataEntrega(Date dataEntrega) {
		this.dataEntrega = dataEntrega;
	}

	public String getTipo() {
		return Tipo;
	}

	public void setTipo(String tipo) {
		Tipo = tipo;
	}

	public BigDecimal getDesconto() {
		return desconto;
	}

	public void setDesconto(BigDecimal desconto) {
		this.desconto = desconto;
	}

	public List<OrdemServicoServico> getServicos() {
		return servicos;
	}

	public List<OrdemServicoProduto> getProdutos() {
		return produtos;
	}

	public TipoOrdemServico getTipoOrdemServico() {
		return tipoOrdemServico;
	}

	public void setTipoOrdemServico(TipoOrdemServico tipoOrdemServico) {
		this.tipoOrdemServico = tipoOrdemServico;
	}
	
	

	
}
