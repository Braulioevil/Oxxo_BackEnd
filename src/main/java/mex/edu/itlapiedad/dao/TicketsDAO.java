package mex.edu.itlapiedad.dao;

import java.util.List;

import mex.edu.itlapiedad.models.Tickets;

public interface TicketsDAO {
	
	Tickets buscar(int id);

	Tickets insertar(Tickets tickets);

	List<Tickets> consultarTickets();

	void actualizar(Tickets tickets);

	void eliminar(int id);
}
