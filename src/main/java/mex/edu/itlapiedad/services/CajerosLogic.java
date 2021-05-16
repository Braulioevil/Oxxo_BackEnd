package mex.edu.itlapiedad.services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mex.edu.itlapiedad.dao.CajerosDAO;
import mex.edu.itlapiedad.models.Cajeros;

@Service
public class CajerosLogic implements CajerosService {
	@Autowired
	CajerosDAO repositorios;

@Override
public Cajeros buscar(int id) {

	return repositorios.buscar(id);
}

@Override
public Cajeros insertar(Cajeros cajeros) {
	
	return repositorios.insertar(cajeros);
}

@Override
public List<Cajeros> consultarCajeros() {
	
	return repositorios.consultarClientes();
}

@Override
public void actualizar(Cajeros cajeros) {
	 repositorios.actualizar(cajeros);
	
}

@Override
public void eliminar(int id) {
	repositorios.eliminar(id);
	
}


}
