  
package br.com.ambers.fiap.bean;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class IndexBean {
	
	private boolean hidden = true;
	private boolean showHide = false;

	public void testar() {
		System.out.println("Executando comando...");
		if(this.showHide == false)
			this.showHide = true;
		else
			this.showHide = false;
		
	}
	
	public boolean showHide() {
		return !showHide;
	}

	public boolean isHidden() {
		return hidden;
	}

	public void setHidden(boolean hidden) {
		this.hidden = hidden;
	}

	public boolean isShowHide() {
		return showHide;
	}

	public void setShowHide(boolean showHide) {
		this.showHide = showHide;
	}
	
	
	
}