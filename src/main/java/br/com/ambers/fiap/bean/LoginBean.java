package br.com.ambers.fiap.bean;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named
@RequestScoped
public class LoginBean {
	/*
	 * private String pattern =
	 * "[\\w\\.-]*[a-zA-Z0-9_]@[\\w\\.-]*[a-zA-Z0-9]\\.[a-zA-Z][a-zA-Z\\.]*[a-zA-Z]";
	 * private Usuario usuario = new Usuario();
	 * 
	 * 
	 * 
	 * try { validate(usuario); } catch (Exception e) {
	 * FacesContext.getCurrentInstance().addMessage(null, new
	 * FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", e.getMessage())); }
	 * System.out.println("Salvando..." + this.usuario); new
	 * UsuarioDao().save(this.usuario);
	 * FacesContext.getCurrentInstance().addMessage(null, new
	 * FacesMessage("Successfully signed up!")); }
	 * 
	 * public String login() { FacesContext context =
	 * FacesContext.getCurrentInstance(); LoginVM = new LoginBean();
	 * 
	 * if (usuario != null) {
	 * context.getExternalContext().getSessionMap().put("user", usuario); return
	 * "index?faces-redirect=true"; }
	 * 
	 * context.getExternalContext().getFlash().setKeepMessages(true);
	 * context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
	 * "Login inválido", "erro")); return "login?faces-redirect=true"; }
	 * 
	 * public String logout() { FacesContext context =
	 * FacesContext.getCurrentInstance();
	 * context.getExternalContext().getSessionMap().remove("user"); return
	 * "login?faces-redirect=true";
	 * 
	 * }
	 * 
	 * public List<Usuario> getUsuarios() { return new UsuarioDao().getAll(); }
	 * 
	 * public Usuario getUsuario() { return usuario; }
	 * 
	 * public void setUsuario(Usuario usuario) { this.usuario = usuario; }
	 * 
	 * public void validate(Usuario usuario) throws Exception { if
	 * (isNullOrEmpty(usuario.getName())) throw new
	 * Exception("Please inform a name!"); }
	 * 
	 * public boolean isNullOrEmpty(String string) { return (string == null ||
	 * string == ""); }
	 * 
	 * public String getPattern() { return pattern; }
	 * 
	 * public void setPattern(String pattern) { this.pattern = pattern; }
	 */

}
