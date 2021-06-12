package br.com.ambers.fiap.services;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;

import br.com.ambers.fiap.viewmodel.HotelVM;
import br.com.fiap.tds.dao.impl.EnderecoDaoImpl;
import br.com.fiap.tds.dao.impl.HotelDaoImpl;
import br.com.fiap.tds.dao.impl.TelefoneDaoImpl;
import br.com.fiap.tds.entity.Hotel;
import br.com.fiap.tds.exception.CommitException;
import br.com.fiap.tds.exception.EntityNotFounfException;
import br.com.fiap.tds.singleton.EntityManagerFactorySingleton;

@Named
@ApplicationScoped
public class HotelService {

	private EntityManager em;
	private HotelDaoImpl dao;
	private TelefoneDaoImpl daoTel;
	private EnderecoDaoImpl daoEnd;

	public HotelService() {
		this.em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		this.dao = new HotelDaoImpl(em);
		this.daoEnd = new EnderecoDaoImpl(em);
		this.daoTel = new TelefoneDaoImpl(em);
	}

	public void adicionar(HotelVM viewModel) throws CommitException {
		Hotel hotel = viewModel.converterParaModel(viewModel);

		daoEnd.create(hotel.getEndereco());
		daoTel.create(hotel.getTelefone());
		dao.create(hotel);
		dao.commit();
	}

	public void adicionar(Hotel model) throws CommitException {
		dao.create(model);
		dao.commit();
	}

	public void atualizar(Hotel model) throws CommitException {
		dao.update(model);
		dao.commit();
	}

	public void atualizar(HotelVM viewModel) throws CommitException {
		Hotel hotel = viewModel.converterParaModel(viewModel);

		daoEnd.update(hotel.getEndereco());
		daoTel.update(hotel.getTelefone());
		dao.update(hotel);
		dao.commit();
	}

	public HotelVM consultarPorId(Integer id) throws EntityNotFounfException {
		HotelVM viewModel = new HotelVM();
		Hotel hotel = dao.read(id);
		return viewModel.converterParaView(hotel);
	}

	public Hotel consultarPorIdRest(Integer id) throws EntityNotFounfException {
		Hotel hotel = dao.read(id);
		return hotel;
	}

	public List<Hotel> findAllRest() {
		return dao.findAll();
	}

	public List<HotelVM> findAll() {
		List<HotelVM> viewList = new ArrayList<HotelVM>();
		List<Hotel> modelList = dao.findAll();

		for (Hotel hotel : modelList) {
			HotelVM view = new HotelVM();
			viewList.add(view.converterParaView(hotel));
		}

		return viewList;
	}

	public void excluirRest(Hotel hotel) throws EntityNotFounfException {
		dao.delete(hotel.getCodigo());

	}

}
