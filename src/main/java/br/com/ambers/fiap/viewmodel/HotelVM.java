package br.com.ambers.fiap.viewmodel;

import java.util.ArrayList;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import br.com.fiap.tds.entity.Avaliacao;
import br.com.fiap.tds.entity.Endereco;
import br.com.fiap.tds.entity.Hotel;

@Named
@ApplicationScoped
public class HotelVM {

	private Hotel hotel;
	
	private int codigo;
	private String nome;
	private String descricao;
	private float preco;
	private String site;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	public Hotel converterParaModel(HotelVM viewModel) {
		Hotel hotel = new Hotel(viewModel.nome, viewModel.descricao, null, viewModel.site, viewModel.preco, "dasijsadpkjsdapkjnfds");
		hotel.setEndereco(new Endereco());
		hotel.setAvaliacoes(new ArrayList<Avaliacao>());
		return hotel;
	}

}
