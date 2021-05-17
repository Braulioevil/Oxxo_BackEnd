package mex.edu.itlapiedad.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mex.edu.itlapiedad.models.Ticket_renglones;
import mex.edu.itlapiedad.services.Ticket_renglonesService;


@RestController
@RequestMapping("/devops/ticket_renglones")

public class Ticket_renglonesWS {

	@Autowired
	Ticket_renglonesService servicio;

	@GetMapping("/{id}")
	public ResponseEntity<?> buscar(@PathVariable int id) {
		Ticket_renglones resultado;
		try {
			resultado = servicio.buscar(id);
		} catch (DataAccessException e) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Ticket_renglones>(resultado, HttpStatus.OK);
	}

	@PostMapping()
	public ResponseEntity<?> insertar(@RequestBody Ticket_renglones ticket_renglones) {
		Ticket_renglones resultado;
		try {
			resultado = servicio.insertar(ticket_renglones);

		} catch (DataAccessException e) {
			System.out.println(e);
			return new ResponseEntity<>(HttpStatus.CONFLICT);
			
		}
		return new ResponseEntity<Ticket_renglones>(resultado, HttpStatus.CREATED);

	}

	@GetMapping()
	public ResponseEntity<?> consultarTicket_renglones() {
		List<Ticket_renglones> resultado;
		try {
			resultado = servicio.consultarTicket_renglones();
		} catch (DataAccessException e) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Ticket_renglones>>(resultado, HttpStatus.OK);
	}

	@PutMapping()
	public ResponseEntity<?> actualizar(@RequestBody Ticket_renglones ticket_renglones) {
		try {
			servicio.actualizar(ticket_renglones);
		} catch (DataAccessException e) {
			System.out.println(e);
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

//metodo de eliminar por id
	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminarProducto(@PathVariable int id) {

		try {
			servicio.eliminar(id);
		} catch (DataAccessException e) {

			return new ResponseEntity<>(HttpStatus.NO_CONTENT);

		}

		return new ResponseEntity<Ticket_renglones>(HttpStatus.OK);

	}

}

