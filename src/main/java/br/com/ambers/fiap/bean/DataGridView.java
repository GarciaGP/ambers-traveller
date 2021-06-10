package br.com.ambers.fiap.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.PrimeFaces;

import br.com.ambers.fiap.model.Product;
import br.com.ambers.fiap.services.ProductService;

@Named
@ViewScoped
public class DataGridView implements Serializable {
	
	  private List<Product> products;
	    private Product selectedProduct;

	    @Inject
	    private ProductService service;

	    @PostConstruct
	    public void init() {
	        products = service.getProducts(48);
	    }

	    public List<Product> getProducts() {
	        return products;
	    }

	    public void setService(ProductService service) {
	        this.service = service;
	    }

	    public Product getSelectedProduct() {
	        return selectedProduct;
	    }

	    public void setSelectedProduct(Product selectedProduct) {
	        this.selectedProduct = selectedProduct;
	    }


	    public void clearMultiViewState() {
	        FacesContext context = FacesContext.getCurrentInstance();
	        String viewId = context.getViewRoot().getViewId();
	        PrimeFaces.current().multiViewState().clearAll(viewId, true, this::showMessage);
	    }

	    private void showMessage(String clientId) {
	        FacesContext.getCurrentInstance()
	                .addMessage(null,
	                        new FacesMessage(FacesMessage.SEVERITY_INFO, clientId + " multiview state has been cleared out", null));
	    }

}
