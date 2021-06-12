package br.com.ambers.fiap.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.ambers.fiap.services.HotelService;
import br.com.fiap.tds.entity.Hotel;
import br.com.fiap.tds.exception.EntityNotFounfException;

@Path("/hoteis")
@Produces(MediaType.APPLICATION_JSON)
public class HotelEndpoint {

	HotelService service;

	public HotelEndpoint() {
		this.service = new HotelService();
	}

	@GET
	public List<Hotel> index() {
		return service.findAllRest();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response create(Hotel hotel) {
		if (hotel == null) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
		try {
			service.adicionar(hotel);
			return Response.status(Response.Status.CREATED).entity(hotel).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
	}

	@GET
	@Path("{id}")
	public Response show(@PathParam("id") Integer id) {
		if (id == null) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
		Hotel hotel;
		try {
			hotel = service.consultarPorIdRest(id);
		} catch (EntityNotFounfException e) {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
		return Response.status(Response.Status.OK).entity(hotel).build();
	}

	@PUT
	@Path("{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response update(@PathParam("id") Integer id, Hotel hotel) {
		if (id == null) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
		if (hotel == null) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
		try {
			if (service.consultarPorIdRest(id) == null) {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
		hotel.setCodigo(id);
			service.atualizar(hotel);
			return Response.status(Response.Status.OK).entity(hotel).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
	}

	@DELETE
	@Path("{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response delete(@PathParam("id") Integer id, Hotel hotel) {
		if (id == null) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
		if (hotel == null) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
		try {
		if (service.consultarPorIdRest(id) == null) {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
		hotel.setCodigo(id);
			service.excluirRest(hotel);
			return Response.status(Response.Status.OK).entity(hotel).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
	}

}
