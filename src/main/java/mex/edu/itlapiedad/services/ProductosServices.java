package mex.edu.itlapiedad.services;

import java.util.List;

import mex.edu.itlapiedad.models.Productos;

public interface ProductosServices {

	Productos buscar(int id);

	Productos insertar(Productos productos);

	List<Productos> consultarProductos();

	void actualizar(Productos productos);

	void eliminar(int id);	

}
