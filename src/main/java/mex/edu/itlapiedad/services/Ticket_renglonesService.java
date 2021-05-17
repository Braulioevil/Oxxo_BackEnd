package mex.edu.itlapiedad.services;

import java.util.List;

import mex.edu.itlapiedad.models.Ticket_renglones;

public interface Ticket_renglonesService {

	Ticket_renglones buscar(int id);

	Ticket_renglones insertar(Ticket_renglones ticket_renglones);

	List<Ticket_renglones> consultarTicket_renglones();

	void actualizar(Ticket_renglones ticket_renglones);

	void eliminar(int id);

	

}