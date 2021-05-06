package mex.edu.itlplapieda.services;

import java.util.List;

import mex.edu.itlplapieda.models.Productos;

public interface ProductosServices {

	Productos buscar(int id);

	Productos insertar(Productos productos);

	List<Productos> consultarProductos();
	
	//Productos insertar(Productos productos);


}
