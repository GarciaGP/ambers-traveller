package br.com.ambers.fiap.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.PrimeFaces;

import br.com.ambers.fiap.services.HotelService;
import br.com.ambers.fiap.viewmodel.HotelVM;
import br.com.fiap.tds.enumeration.Tipo;
import br.com.fiap.tds.enumeration.Uf;
import br.com.fiap.tds.exception.CommitException;

@Named
@ViewScoped
public class CrudView implements Serializable {

	private static final long serialVersionUID = 1L;

	private Uf[] ufs = Uf.values();

	private Tipo tipos[] = Tipo.values();

	private String tipoSelecionado;

	private String ufSelecionado;

	private List<HotelVM> hospedagens;

	private HotelVM hospedagemSelecionada;

	private List<HotelVM> hospedagensSelecionadas;

	@Inject
	private HotelService service;

	@PostConstruct
	public void init() {
		this.hospedagensSelecionadas = new ArrayList<HotelVM>();
		this.hospedagens = service.findAll();
		System.out.println("Componente iniciado");
		// TODO Implementar busca de todos as hospedagens cadastradas
	}

	public String getUfSelecionado() {
		return ufSelecionado;
	}

	public void setUfSelecionado(String ufSelecionado) {
		this.ufSelecionado = ufSelecionado;
	}

	public String getTipoSelecionado() {
		return tipoSelecionado;
	}

	public void setTipoSelecionado(String tipoSelecionado) {
		this.tipoSelecionado = tipoSelecionado;
	}

	public Tipo[] getTipos() {
		return tipos;
	}

	public void setTipos(Tipo[] tipos) {
		this.tipos = tipos;
	}

	public Uf[] getUfs() {
		return ufs;
	}

	public void setUfs(Uf[] ufs) {
		this.ufs = ufs;
	}

	public HotelVM getHospedagemSelecionada() {
		return hospedagemSelecionada;
	}

	public void setHospedagemSelecionada(HotelVM hospedagemSelecionada) {
		this.hospedagemSelecionada = hospedagemSelecionada;
	}

	public List<HotelVM> getHospedagensSelecionadas() {
		return hospedagensSelecionadas;
	}

	public void setHospedagensSelecionadas(List<HotelVM> hospedagensSelecionadas) {
		this.hospedagensSelecionadas = hospedagensSelecionadas;
	}

	public void setHospedagens(List<HotelVM> hoteis) {
		this.hospedagens = hoteis;
	}

	public List<HotelVM> getHospedagens() {
		return hospedagens;
	}

	public void openNew() {
		this.hospedagemSelecionada = new HotelVM();
	}

	public void saveProduct() {
		this.hospedagemSelecionada.getEndereco().setUf(Uf.valueOf(ufSelecionado));
		this.hospedagemSelecionada.setTipo(Tipo.valueOf(tipoSelecionado));
		this.hospedagemSelecionada.setTipo(Tipo.LAZER);

		if (this.hospedagemSelecionada.getCodigo() == 0) {
			this.hospedagens.add(this.hospedagemSelecionada);
			try {
				service.adicionar(hospedagemSelecionada);
			} catch (CommitException e) {
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERRO!", e.getMessage()));
				e.printStackTrace();
			}
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Hotel adicionado!"));
		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Product Updated"));
		}
		PrimeFaces.current().executeScript("PF('manageProductDialog').hide()");
		PrimeFaces.current().ajax().update("form:messages", "form:dt-products");
	}

	/*
	 * public void deleteProduct() { try {
	 * this.dao.delete(hospedagemSelecionada.getCodigo());
	 * FacesContext.getCurrentInstance().addMessage(null, new
	 * FacesMessage("Product Removed")); } catch (EntityNotFounfException e) {
	 * FacesContext.getCurrentInstance().addMessage(null, new
	 * FacesMessage(e.getMessage())); e.printStackTrace(); }
	 * this.hospedagemSelecionada = null;
	 * PrimeFaces.current().ajax().update("form:messages", "form:dt-products"); }
	 */

	public String getDeleteButtonMessage() {
		if (hasSelectedProducts()) {
			int size = this.hospedagensSelecionadas.size();
			return size > 1 ? size + " products selected" : "1 product selected";
		}

		return "Delete";
	}

	public boolean hasSelectedProducts() {
		return this.hospedagensSelecionadas != null && !this.hospedagensSelecionadas.isEmpty();
	}

	public void deleteSelectedProducts() {
		// this.hoteis.removeAll(this.hospedagemSelecionada);
		this.hospedagensSelecionadas = null;
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Hospedagem removida!"));
		PrimeFaces.current().ajax().update("form:messages", "form:dt-products");
		PrimeFaces.current().executeScript("PF('dtProducts').clearFilters()");
	}
}
