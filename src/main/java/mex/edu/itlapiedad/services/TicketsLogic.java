package mex.edu.itlapiedad.services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mex.edu.itlapiedad.dao.TicketsDAO;
import mex.edu.itlapiedad.models.Tickets;

@Service

public class TicketsLogic implements TicketsService{
	@Autowired
	TicketsDAO repositorios;
	
	
	@Override
	public Tickets buscar(int id) {
		return repositorios.buscar(id);
	}

	@Override
	public Tickets insertar(Tickets tickets) {
		return repositorios.insertar(tickets);
	}

	@Override
	public List<Tickets> consultarTickets() {
		return repositorios.consultarTickets();
	}

	@Override
	public void actualizar(Tickets tickets) {
		 repositorios.actualizar(tickets);
		
	}

	@Override
	public void eliminar(int id) {
		repositorios.eliminar(id);
		
	}
}
