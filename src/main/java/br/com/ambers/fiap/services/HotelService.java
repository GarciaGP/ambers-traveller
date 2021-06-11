package br.com.ambers.fiap.services;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;

import br.com.ambers.fiap.viewmodel.HotelVM;
import br.com.fiap.tds.dao.HotelDao;
import br.com.fiap.tds.dao.impl.HotelDaoImpl;
import br.com.fiap.tds.entity.Hotel;
import br.com.fiap.tds.singleton.EntityManagerFactorySingleton;

@Named
@ApplicationScoped
public class HotelService {

	public void adicionar(HotelVM hotelViewModel) {
		// Obter um Entity Manager
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();

		Hotel hotel = hotelViewModel.converterParaModel(hotelViewModel);

		HotelDaoImpl dao = new HotelDaoImpl(em);

		dao.create(hotel);

	}
	
	public List<Hotel> listar() {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		
		HotelDaoImpl dao = new HotelDaoImpl(em);
		
		// dao.read(null);
		
		return null;
		
	}

}
