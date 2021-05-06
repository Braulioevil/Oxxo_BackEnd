package mex.edu.itlplapieda.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mex.edu.itlplapieda.dao.ProductosDao;
import mex.edu.itlplapieda.models.Productos;
import mex.edu.itlplapieda.services.ProductosServices;

@Service

public class ProductosLogic implements ProductosServices {
	
    @Autowired
    ProductosDao repositorio;
	
	@Override
	public List<Productos> consultarProductos() {

		return repositorio.consultarProductos();
	}

	@Override
	public Productos buscar(int id) {
		// TODO Auto-generated method stub
		return repositorio.buscar(id);
	}
	
	@Override
	public Productos insertar(Productos productos) {
		
		return repositorio.insertar(productos);
	}

}
