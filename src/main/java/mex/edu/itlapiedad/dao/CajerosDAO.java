package mex.edu.itlapiedad.dao;

import java.util.List;

import mex.edu.itlapiedad.models.Cajeros;

public interface CajerosDAO {

	List<Cajeros> consultarClientes();

	Cajeros buscar(int id);

	Cajeros insertar(Cajeros cajeros);

	void actualizar(Cajeros cajeros);

	void eliminar(int id);

}

