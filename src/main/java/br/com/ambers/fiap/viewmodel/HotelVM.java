package br.com.ambers.fiap.viewmodel;

import java.util.ArrayList;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import br.com.ambers.fiap.viewmodel.*;

import br.com.fiap.tds.entity.Avaliacao;
import br.com.fiap.tds.entity.Endereco;
import br.com.fiap.tds.entity.Hotel;
import br.com.fiap.tds.entity.Telefone;
import br.com.fiap.tds.enumeration.Tipo;

@Named
@ApplicationScoped
public class HotelVM {
	
	public HotelVM() {
		this.telefone = new TelefoneVM();
		this.endereco = new EnderecoVM();
	}
	
	private int codigo;
	private String nome;
	private String descricao;
	private Tipo tipo;
	private String site;
	private float preco;
	private String base64Imagem;
	private TelefoneVM telefone;
	private EnderecoVM endereco;
	private float mediaAvaliacoes;
	
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
	
	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public String getBase64Imagem() {
		return base64Imagem;
	}

	public void setBase64Imagem(String base64Imagem) {
		this.base64Imagem = base64Imagem;
	}

	public TelefoneVM getTelefone() {
		return telefone;
	}

	public void setTelefone(TelefoneVM telefone) {
		this.telefone = telefone;
	}

	public EnderecoVM getEndereco() {
		return endereco;
	}

	public void setEndereco(EnderecoVM endereco) {
		this.endereco = endereco;
	}

	public float getMediaAvaliacoes() {
		return mediaAvaliacoes;
	}

	public void setMediaAvaliacoes(float mediaAvaliacoes) {
		this.mediaAvaliacoes = mediaAvaliacoes;
	}

	public Hotel converterParaModel(HotelVM viewModel) {
		Telefone telefone = viewModel.telefone.converterParaModel(viewModel.telefone);
		Endereco endereco = viewModel.endereco.converterParaModel(viewModel.endereco);
		
		Hotel hotel = new Hotel();
		hotel.setNome(viewModel.nome);
		hotel.setDescricao(viewModel.descricao);
		hotel.setTipo(viewModel.tipo);
		hotel.setSite(viewModel.site);
		hotel.setPreco(viewModel.preco);
		hotel.setBase64Imagem(viewModel.base64Imagem);
		hotel.setTelefone(telefone);
		hotel.setEndereco(endereco);
		hotel.setAvaliacoes(new ArrayList<Avaliacao>());
		telefone.addHotel(hotel);
		endereco.addHotel(hotel);
		
		return hotel;
	}

}
