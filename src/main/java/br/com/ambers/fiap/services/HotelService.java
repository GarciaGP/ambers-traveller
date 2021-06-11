package br.com.ambers.fiap.services;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;

import br.com.ambers.fiap.viewmodel.HotelVM;
import br.com.fiap.tds.dao.impl.HotelDaoImpl;
import br.com.fiap.tds.entity.Hotel;
import br.com.fiap.tds.singleton.EntityManagerFactorySingleton;

@Named
@ApplicationScoped
public class HotelService {
	
	private EntityManager em;
	private HotelDaoImpl dao;
	
	public HotelService() {
		this.em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		this.dao = new HotelDaoImpl(em);
	}

	public void adicionar(HotelVM viewModel) {
		Hotel hotel = viewModel.converterParaModel(viewModel);
		dao.create(hotel);
	}
	
	public List<Hotel> listar() {
		// dao.read(null);		
		return null;
		
	}

}
