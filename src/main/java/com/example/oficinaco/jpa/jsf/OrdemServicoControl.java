package com.example.oficinaco.jpa.jsf;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.SessionScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.oficinaco.jpa.dao.OrdemServicoDao;
import com.example.oficinaco.jpa.dao.OrdemServicoProdutoDao;
import com.example.oficinaco.jpa.dao.OrdemServicoServicoDao;
import com.example.oficinaco.jpa.dao.PessoaDao;
import com.example.oficinaco.jpa.dao.PessoaDaoImpl;
import com.example.oficinaco.jpa.dao.ProdutoDao;
import com.example.oficinaco.jpa.dao.ServicoDao;
import com.example.oficinaco.jpa.dao.VeiculoDao;
import com.example.oficinaco.jpa.dao.VeiculoDaoImpl;
import com.example.oficinaco.jpa.entidade.EnumUf;
import com.example.oficinaco.jpa.entidade.OrdemServico;
import com.example.oficinaco.jpa.entidade.OrdemServicoProduto;
import com.example.oficinaco.jpa.entidade.OrdemServicoServico;
import com.example.oficinaco.jpa.entidade.Pessoa;
import com.example.oficinaco.jpa.entidade.Produto;
import com.example.oficinaco.jpa.entidade.Servico;
import com.example.oficinaco.jpa.entidade.TipoOrdemServico;
import com.example.oficinaco.jpa.entidade.Veiculo;

@Component
@SessionScoped
public class OrdemServicoControl {
	
	private Integer pessoaId;
	
	private Integer veiculoId;
	
	private Integer servicoId;

	private Integer produtoId;
	
	private Integer funcionarioId;
	
	@Autowired
	private PessoaDao pessoaDao;
	
	@Autowired
	private VeiculoDao veiculoDao;
	
	@Autowired
	private VeiculoDaoImpl veiculoDaoImpl;
	
	@Autowired
	private ProdutoDao produtoDao;
    
	private String placa;
	
	private OrdemServico ordemServico = new OrdemServico();
	private List<OrdemServico> ordemServicos = new ArrayList<>();
	
	private OrdemServicoServico ordemServicoServico = new OrdemServicoServico();
	
	private OrdemServicoProduto ordemServicoProduto = new OrdemServicoProduto();
	
	@Autowired
	private PessoaDaoImpl pessoaDaoImpl;
	
	@Autowired
	private ServicoDao servicoDao;
	
	@Autowired
	private OrdemServicoDao ordemservicoDao;
	
	@Autowired
	private OrdemServicoServicoDao ordemservicoservicoDao;
	
	@Autowired
	private OrdemServicoProdutoDao ordemservicoprodutoDao;
	
	public TipoOrdemServico[] getTipoOrdemServicos(){
		return TipoOrdemServico.values();
	}
	
	public void atualizarVeiculo() {
		Veiculo veiculo = veiculoDao.consultarPorPlaca(placa);
		ordemServico.setVeiculo(veiculo);
	}
	
	public void salvar() {
		ordemServico.setCliente(pessoaDao.findByIdPessoa(pessoaId));
		ordemServico.setFuncionario(pessoaDao.findByIdPessoa(funcionarioId));
		ordemServico.setVeiculo(veiculoDao.findByIdVeiculo(veiculoId));
		ordemservicoDao.save(ordemServico);
		listar();
	}
	public void listar() {
		ordemServicos = ordemservicoDao.findAll();
	}
	public void selecionarServico() {
		Servico servico = servicoDao.findById(servicoId).get();
		ordemServicoServico.setServico(servico);
		ordemServicoServico.setPreco(servico.getPreco());
	}
	
	public void addServico() {
		ordemServico.getServicos().add(ordemServicoServico);
		servicoId = null;
		ordemServicoServico = new OrdemServicoServico();
		
	}

	public void selecionarProduto() {
        Produto produto = produtoDao.findById(produtoId).get();
        ordemServicoProduto.setProduto(produto);
        ordemServicoProduto.setPreco(produto.getPrecoVenda());
    }
	
	public void addProduto() {
		ordemServico.getProdutos().add(ordemServicoProduto);
		produtoId = null;
		ordemServicoProduto = new OrdemServicoProduto();
		
	}
    public List<Pessoa> completePessoa(String query) {
    	return pessoaDaoImpl.listarPorNome("%" + query + "%", null);
    }	

    public List<Servico> completeServico(String query) {
    	return servicoDao.listarPorNome("%" + query + "%");
    }	

    public List<Produto> completeProduto(String query) {
    	return produtoDao.listarPorNome("%" + query + "%");
    }	
    
    public List<Pessoa> completeFuncionario(String query) {
    	return pessoaDaoImpl.listarPorNome("%" + query + "%", true);
    }	
    
    public List<Veiculo> completeVeiculo(String query) {
    	return veiculoDaoImpl.listarPorPlaca("%" + query + "%");
    }
	public Integer getPessoaId() {
		return pessoaId;
	}

	public void setPessoaId(Integer pessoaId) {
		this.pessoaId = pessoaId;
	}

	public Integer getFuncionarioId() {
		return funcionarioId;
	}

	public void setFuncionarioId(Integer funcionarioId) {
		this.funcionarioId = funcionarioId;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public OrdemServico getOrdemServico() {
		return ordemServico;
	}

	public void setOrdemServico(OrdemServico ordemServico) {
		this.ordemServico = ordemServico;
	}

	public Integer getServicoId() {
		return servicoId;
	}

	public void setServicoId(Integer servicoId) {
		this.servicoId = servicoId;
	}
	public void setProdutoId(Integer produtoId) {
		this.produtoId = produtoId;
	}

	public Integer getProdutoId() {
		return produtoId;
	}

	
	public OrdemServicoServico getOrdemServicoServico() {
		return ordemServicoServico;
	}

	public void setOrdemServicoServico(OrdemServicoServico ordemServicoServico) {
		this.ordemServicoServico = ordemServicoServico;
	}

	public OrdemServicoProduto getOrdemServicoProduto() {
		return ordemServicoProduto;
	}

	public void setOrdemServicoProduto(OrdemServicoProduto ordemServicoProduto) {
		this.ordemServicoProduto = ordemServicoProduto;
	}

	public Integer getVeiculoId() {
		return veiculoId;
	}

	public void setVeiculoId(Integer veiculoId) {
		this.veiculoId = veiculoId;
	}

	
}
