package br.com.ambers.fiap.services;

import javax.persistence.EntityManager;

import br.com.ambers.fiap.viewmodel.LoginVM;
import br.com.fiap.tds.dao.impl.LoginDaoImpl;
import br.com.fiap.tds.entity.Login;
import br.com.fiap.tds.exception.EntityNotFounfException;
import br.com.fiap.tds.singleton.EntityManagerFactorySingleton;

public class LoginService {
	
	private EntityManager em;
	private LoginDaoImpl dao;
	
	public LoginService() {
		this.em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		this.dao = new LoginDaoImpl(em);
	}
	
	public Login consultarLogin(LoginVM login) throws EntityNotFounfException {
		return dao.read(1);
	}

	public boolean validar(LoginVM login) {
		Login loginEntity = dao.buscarPorEmailESenha(login.getEmail(), login.getSenha());
		return loginEntity != null;
	}


}
