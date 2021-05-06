package mex.edu.itlplapieda.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mex.edu.itlplapieda.models.Productos;
import mex.edu.itlplapieda.services.ProductosServices;

@RestController
@RequestMapping("/devops/productos")

public class ProductosWS {
	
	@Autowired
    ProductosServices servicio;

    @GetMapping("/{id}")
    public ResponseEntity<?> buscar(@PathVariable int id){
        Productos resultado;
        try {
            resultado=servicio.buscar(id);
        } catch (DataAccessException e) {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<Productos>(resultado,HttpStatus.OK);
    }
    
    @PostMapping()
	public ResponseEntity<?>insertar(@RequestBody Productos productos){
		Productos resultado;
	try {
		resultado=servicio.insertar(productos);
		
	} catch (DataAccessException e) {
	return new ResponseEntity<>(HttpStatus.CONFLICT);
	}	
		return new ResponseEntity<Productos>(resultado,HttpStatus.CREATED);
		
	}
	@GetMapping()
	public ResponseEntity<?> consultarProductos(){
		List<Productos> resultado;
		try {
			resultado = servicio.consultarProductos();
		}catch (DataAccessException e) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Productos>>(resultado,HttpStatus.OK);
	}

}
