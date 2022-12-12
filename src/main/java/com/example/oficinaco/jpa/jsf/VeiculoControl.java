package com.example.oficinaco.jpa.jsf;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.SessionScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.oficinaco.jpa.dao.ModeloDao;
import com.example.oficinaco.jpa.dao.ModeloDaoImpl;
import com.example.oficinaco.jpa.dao.PessoaDao;
import com.example.oficinaco.jpa.dao.PessoaDaoImpl;
import com.example.oficinaco.jpa.dao.VeiculoDao;
import com.example.oficinaco.jpa.entidade.Modelo;
import com.example.oficinaco.jpa.entidade.Pessoa;
import com.example.oficinaco.jpa.entidade.Veiculo;

@Component
@SessionScoped
public class VeiculoControl {

    private Integer pessoaId;
    
    private Integer modeloId;

    @Autowired
    private PessoaDaoImpl pessoaDaoImpl;

    @Autowired
    private VeiculoDao veiculoDao;

    private Veiculo veiculo = new Veiculo();

    private List<Veiculo> veiculos = new ArrayList<>();

    @Autowired
    private PessoaDao pessoaDao;
    
    @Autowired
    private ModeloDaoImpl modeloDaoImpl;
    
    @Autowired
    private ModeloDao modeloDao;

    private Pessoa pessoa = new Pessoa();

    @PostConstruct
    public void init() {
        listar();
    }


    public List<Pessoa> completePessoa(String query) {
    	return pessoaDaoImpl.listarPorNome("%" + query + "%", null);
    }	
    public List<Modelo> completeModelo(String query) {
    	return modeloDaoImpl.listarPorNome("%" + query + "%");
    }

    public void salvar() {
    	veiculo.setModelo(modeloDao.findbyModelo(modeloId));
    	veiculo.setProprietario(pessoaDao.findByIdPessoa(pessoaId));
        veiculoDao.save(veiculo);
        veiculo = new Veiculo();
        listar();
    }
public void listar() {
        veiculos = veiculoDao.findAll();
    }

    public void excluir(Integer id) {
        veiculoDao.deleteById(id);
        listar();
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public List<Veiculo> getVeiculos() {
        return veiculos;
    }

    public void setVeiculos(List<Veiculo> veiculos) {
        this.veiculos = veiculos;
    }

    public Integer getPessoaId() {
        return pessoaId;
    }

    public void setPessoaId(Integer pessoaId) {
        this.pessoaId = pessoaId;
    }

    public Integer getModeloId() {
        return modeloId;
    }

    public void setModeloId(Integer modeloId) {
        this.modeloId = modeloId;
    }
}