package mex.edu.itlapiedad.dao;

import java.sql.Timestamp;
import java.util.List;

import mex.edu.itlapiedad.models.Ticket_Renglones_Importe;
import mex.edu.itlapiedad.models.Ticket_renglones;


public interface Ticket_renglonesDAO {

	Ticket_renglones buscar(int id);

	Ticket_renglones insertar(Ticket_renglones ticket_renglones);

	List<Ticket_renglones> consultarTicket_renglones();

	void actualizar(Ticket_renglones ticket_renglones);

	void eliminar(int id);

	List<Ticket_Renglones_Importe> totalFecha(Timestamp fecha_hora);
	
	List<Ticket_Renglones_Importe> totalNombre(String nombre);
	

	List<Ticket_Renglones_Importe> totalId(int id);
}


