package mex.edu.itlplapieda.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import mex.edu.itlplapieda.dao.ProductosDao;
import mex.edu.itlplapieda.models.Productos;

@Service
public class ProductosLogic implements ProductosServices {

	@Autowired 
	ProductosDao repositorio;
	@Override
	public Productos buscar(int id) {
		// TODO Auto-generated method stub
		return repositorio.buscar(id);
	}

	
}
