package mex.edu.itlapiedad.services;
import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import mex.edu.itlapiedad.dao.Ticket_renglonesDAO;
import mex.edu.itlapiedad.models.Ticket_Renglones_Importe;
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

	@Override
	public List<Ticket_Renglones_Importe> totalFecha(Timestamp fecha_hora) {
		// TODO Auto-generated method stub
		return repositorio.totalFecha(fecha_hora);
	}
	

@Override
public List<Ticket_Renglones_Importe> totalNombre(String nombre) {
	// TODO Auto-generated method stub
	return repositorio.totalNombre(nombre);
}
}

