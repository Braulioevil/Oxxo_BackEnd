package mex.edu.itlapiedad.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import mex.edu.itlapiedad.models.Ticket_renglones;

@Repository
public class Ticket_renglonesJDBC implements Ticket_renglonesDAO {
	@Autowired
	JdbcTemplate conexion;

	@Override
	public Ticket_renglones buscar(int id) {
		String sql_query = "SELECT * FROM ticket_renglones WHERE id=?";
		return conexion.queryForObject(sql_query, new RowMapper<Ticket_renglones>() {
			public Ticket_renglones mapRow(ResultSet rs, int rowNum) throws SQLException {
				Ticket_renglones ticket_renglones = new Ticket_renglones();
				ticket_renglones.setId(rs.getInt("id"));
				ticket_renglones.setTICKET_id(rs.getInt("TICKET_id"));
				ticket_renglones.setPRODUCTO_id(rs.getInt("PRODUCTO_id"));
				ticket_renglones.setCantidad(rs.getInt("cantidad"));
				ticket_renglones.setPrecio(rs.getFloat("precio"));
				ticket_renglones.setImporte(rs.getFloat("importe"));
				ticket_renglones.setActivo(rs.getInt("activo"));
				return ticket_renglones;
			}

		}, id);
	}

	@Override
	public Ticket_renglones insertar(Ticket_renglones ticket_renglones) {

		SimpleJdbcInsert insert = new SimpleJdbcInsert(conexion).withTableName("ticket_renglones")
				.usingColumns("cantidad", "precio", "TICKET_id","PRODUCTO_id").usingGeneratedKeyColumns("id");
		Map<String, Object> datos = new HashMap<>();
		datos.put("cantidad", ticket_renglones.getCantidad());
		datos.put("precio", ticket_renglones.getPrecio());
	//	datos.put("importe", ticket_renglones.getImporte());
		datos.put("TICKET_id", ticket_renglones.getTICKET_id());
		datos.put("PRODUCTO_id", ticket_renglones.getPRODUCTO_id());
		
		Number id = insert.executeAndReturnKey(datos);
		ticket_renglones.setId(id.intValue());
		ticket_renglones.setActivo(1);
		return ticket_renglones;
	}

	@Override
	public List<Ticket_renglones> consultarTicket_renglones() {
		// TODO Auto-generated method stub
		String sql_query = "SELECT * FROM ticket_renglones where activo=1";
		return conexion.query(sql_query, new RowMapper<Ticket_renglones>() {
			public Ticket_renglones mapRow(ResultSet rs, int rowNum) throws SQLException {
				Ticket_renglones ticket_renglones = new Ticket_renglones();
				ticket_renglones.setId(rs.getInt("id"));
				ticket_renglones.setTICKET_id(rs.getInt("TICKET_id"));
				ticket_renglones.setPRODUCTO_id(rs.getInt("PRODUCTO_id"));
				ticket_renglones.setCantidad(rs.getInt("cantidad"));
				ticket_renglones.setPrecio(rs.getFloat("precio"));
				ticket_renglones.setImporte(rs.getFloat("importe"));
				ticket_renglones.setActivo(rs.getInt("activo"));
				return ticket_renglones;

			}

		});
	}

	@Override
	public void actualizar(Ticket_renglones ticket_renglones) {
		String sql_update = "UPDATE ticket_renglones SET cantidad = ?, precio = ?, TICKET_id=?, PRODUCTO_id=? " + " WHERE id = ?";
		conexion.update(sql_update,
				ticket_renglones.getCantidad(), 
				ticket_renglones.getPrecio(),
			//	ticket_renglones.getImporte(), 
				ticket_renglones.getTICKET_id(), 
				ticket_renglones.getPRODUCTO_id(), 
				ticket_renglones.getId());
		
		

	}

	@Override
	public void eliminar(int id) {
		String sql_update="UPDATE ticket_renglones SET activo=0 WHERE id=?";
		conexion.update(sql_update,id);
	}

}