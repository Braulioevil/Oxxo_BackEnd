package mex.edu.itlapiedad.dao;

import java.util.List;

import mex.edu.itlapiedad.models.Productos;

public interface ProductosDao {

	Productos buscar(int id);

	Productos insertar(Productos productos);

	List<Productos> consultarProductos1();

	List<Productos> consultarProductos();

	


}
