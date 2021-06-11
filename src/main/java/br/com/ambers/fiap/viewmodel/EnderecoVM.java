package br.com.ambers.fiap.viewmodel;

import java.util.List;

import br.com.fiap.tds.entity.Endereco;
import br.com.fiap.tds.entity.Hotel;
import br.com.fiap.tds.enumeration.Uf;

public class EnderecoVM {
	
	private Integer codigo;
	private String estado;
	private Uf uf;
	private String base64Imagem;
	private Float distancia;
	private List<HotelVM> hoteis;
	
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public Uf getUf() {
		return uf;
	}
	public void setUf(Uf uf) {
		this.uf = uf;
	}
	public String getBase64Imagem() {
		return base64Imagem;
	}
	public void setBase64Imagem(String base64Imagem) {
		this.base64Imagem = base64Imagem;
	}
	public Float getDistancia() {
		return distancia;
	}
	public void setDistancia(Float distancia) {
		this.distancia = distancia;
	}
	public List<HotelVM> getHoteis() {
		return hoteis;
	}
	public void setHoteis(List<HotelVM> hoteis) {
		this.hoteis = hoteis;
	}
	
	public Endereco converterParaModel(EnderecoVM viewModel) {
		Endereco model = new Endereco();
		model.setCodigo(viewModel.codigo);
		model.setEstado(viewModel.estado);
		model.setUf(viewModel.uf);
		model.setDistancia(viewModel.distancia);
		return model;
	}

}
