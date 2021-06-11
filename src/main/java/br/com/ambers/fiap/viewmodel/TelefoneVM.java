package br.com.ambers.fiap.viewmodel;

import java.util.List;

import br.com.fiap.tds.entity.Telefone;

public class TelefoneVM {
	private Integer codigo;
	private String telefone;
	private String ddd;
	private String celular;
	private String telefoneSecundario;
	private List<HotelVM> hoteis;
	
	
	
	public Integer getCodigo() {
		return codigo;
	}



	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}



	public String getTelefone() {
		return telefone;
	}



	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}



	public String getDdd() {
		return ddd;
	}



	public void setDdd(String ddd) {
		this.ddd = ddd;
	}



	public String getCelular() {
		return celular;
	}



	public void setCelular(String celular) {
		this.celular = celular;
	}



	public String getTelefoneSecundario() {
		return telefoneSecundario;
	}



	public void setTelefoneSecundario(String telefoneSecundario) {
		this.telefoneSecundario = telefoneSecundario;
	}



	public List<HotelVM> getHoteis() {
		return hoteis;
	}



	public void setHoteis(List<HotelVM> hoteis) {
		this.hoteis = hoteis;
	}



	public Telefone converterParaModel(TelefoneVM viewModel) {
		Telefone model = new Telefone();
		model.setCodigo(viewModel.codigo);
		model.setTelefone(viewModel.telefone);
		model.setDdd(viewModel.ddd);
		model.setCelular(viewModel.celular);
		model.setTelefoneSecundario(viewModel.telefoneSecundario);
		return model;
	}
}
