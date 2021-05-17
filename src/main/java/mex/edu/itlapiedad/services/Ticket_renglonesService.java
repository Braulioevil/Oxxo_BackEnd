package mex.edu.itlapiedad.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mex.edu.itlapiedad.dao.Ticket_renglones.Ticket_renglonesDAO;
import mex.edu.itlapiedad.models.Ticket_renglones;

@Service
public class Ticket_renglonesLogic implements Ticket_renglonesService {
	@Autowired
	Ticket_renglonesDAO repositorio;

	@Override
	public Ticket_renglones buscar(int id) {
		// TODO Auto-generated method stub
		return repositorio.buscar(id);
	}

	@Override
	public Ticket_renglones insertar(Ticket_renglones ticket_renglones) {
		// TODO Auto-generated method stub
		return repositorio.insertar(ticket_renglones);
	}

	@Override
	public List<Ticket_renglones> consultarTicket_renglones() {
		// TODO Auto-generated method stub
		return repositorio.consultarTicket_renglones();
	}

	@Override
	public void actualizar(Ticket_renglones ticket_renglones) {
		// TODO Auto-generated method stub
repositorio.actualizar(ticket_renglones);
	}

	@Override
	public void eliminar(int id) {
		// TODO Auto-generated method stub
repositorio.eliminar(id);
	}
}
