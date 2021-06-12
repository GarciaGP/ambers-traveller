package br.com.ambers.fiap.bean;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import br.com.ambers.fiap.services.LoginService;
import br.com.ambers.fiap.viewmodel.LoginVM;

@Named
@RequestScoped
public class LoginBean {
	private String pattern = "[\\w\\.-]*[a-zA-Z0-9_]@[\\w\\.-]*[a-zA-Z0-9]\\.[a-zA-Z][a-zA-Z\\.]*[a-zA-Z]";
	private LoginVM login = new LoginVM();

	public String login() {
		FacesContext context = FacesContext.getCurrentInstance();
		LoginService service = new LoginService();
		try {

			boolean loginValido = service.validar(login);

			if (loginValido) {
				context.getExternalContext().getSessionMap().put("user", login);
				return "ManagementCrud?faces-redirect=true";
			}

		} catch (Exception e) {

			context.getExternalContext().getFlash().setKeepMessages(true);
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Login inválido", "erro"));
		}

		return "login?faces-redirect=true";
	}

	public String logout() {
		FacesContext context = FacesContext.getCurrentInstance();
		context.getExternalContext().getSessionMap().remove("user");
		return "login?faces-redirect=true";

	}

	public LoginVM getLoginVM() {
		return login;
	}

	public void setLoginVM(LoginVM login) {
		this.login = login;
	}

	public boolean isNullOrEmpty(String string) {
		return (string == null || string == "");
	}

	public String getPattern() {
		return pattern;
	}

	public void setPattern(String pattern) {
		this.pattern = pattern;
	}

}
