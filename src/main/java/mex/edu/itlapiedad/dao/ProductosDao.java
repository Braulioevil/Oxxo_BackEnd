package mex.edu.itlapiedad.dao;
import java.util.List;

import mex.edu.itlapiedad.models.Productos;

public interface ProductosDao {

	List<Productos> consultarProductos();

	Productos buscar(int id);

	Productos insertar(Productos productos);

	void actualizar(Productos productos);

	void eliminar(int id);

	List<Productos> consultarProductos1();

	

}
