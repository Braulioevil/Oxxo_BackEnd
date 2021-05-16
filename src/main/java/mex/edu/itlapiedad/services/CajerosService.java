package mex.edu.itlapiedad.services;

import java.util.List;

import mex.edu.itlapiedad.models.Cajeros;

public interface CajerosService {

	Cajeros buscar(int id);

	Cajeros insertar(Cajeros cajeros);

	List<Cajeros> consultarCajeros();

	void actualizar(Cajeros cajeros);

	void eliminar(int id);

 }


