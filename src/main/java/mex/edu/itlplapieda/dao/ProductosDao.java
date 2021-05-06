package mex.edu.itlplapieda.dao;

import java.util.List;

import mex.edu.itlplapieda.models.Productos;

public interface ProductosDao {

	Productos buscar(int id);

	Productos insertar(Productos productos);

	List<Productos> consultarProductos();


}
