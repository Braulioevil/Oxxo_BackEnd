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

import mex.edu.itlapiedad.models.Productos;

@Repository

public class ProductosJdbc implements ProductosDao {
	@Autowired
	JdbcTemplate conexion;
	
	
	@Override
	public List<Productos> consultarProductos() {
		String sql_query = "SELECT * FROM productos where activo=1";
		return conexion.query(sql_query, new RowMapper<Productos>() {
			public Productos mapRow(ResultSet rs,int rowNum) throws SQLException {
				Productos productos = new Productos();
				productos.setId(rs.getInt("id"));
				productos.setDescripcion(rs.getString("descripcion"));
				productos.setPrecio(rs.getFloat("precio"));
				productos.setCodigo_barras(rs.getString("codigo_barras"));
				productos.setExistencia(rs.getInt("existencia"));
				productos.setActivo(rs.getInt("activo"));
				return productos;
				
			}

			
		});
	}


	@Override
	public Productos buscar(int id) {
		String sql_query = "SELECT * FROM productos WHERE id=?";
		return conexion.queryForObject(sql_query, new RowMapper<Productos>() {
			public Productos mapRow(ResultSet rs, int rowNum) throws SQLException {
				Productos productos = new Productos();
				productos.setId(rs.getInt("id"));
				productos.setDescripcion(rs.getString("descripcion"));
				productos.setPrecio(rs.getFloat("precio"));
				productos.setCodigo_barras(rs.getString("codigo_barras"));
				productos.setExistencia(rs.getInt("existencia"));
				productos.setActivo(rs.getInt("activo"));
				return productos;
			}
			
		},id);
	}
	
	@Override
	public Productos insertar(Productos productos) {
		
		SimpleJdbcInsert insert=new SimpleJdbcInsert(conexion).withTableName("productos")
				.usingColumns("descripcion","precio","codigo_barras","existencia")
				.usingGeneratedKeyColumns("id");
		Map<String,Object> datos = new HashMap<>();
		datos.put("descripcion", productos.getDescripcion());
	         datos.put("precio", productos.getPrecio());
	datos.put("codigo_barras", productos.getCodigo_barras());
	datos.put("existencia", productos.getExistencia());
	
		Number id=insert.executeAndReturnKey(datos);
		productos.setActivo(1);
		productos.setId(id.intValue());
		return productos;
	}
	
	
	@Override
	public void actualizar(Productos productos) {
		String sql_update = "UPDATE productos SET descripcion = ?, precio = ?, codigo_barras = ?, "
				+ "existencia = ? WHERE id = ?";
		conexion.update(sql_update, 
		        productos.getDescripcion(),
		        productos.getPrecio(),
		        productos.getCodigo_barras(),
		        productos.getExistencia(),
		        productos.getId());
		        
			}


	@Override
	public void eliminar(int id) {
		String sql_update="UPDATE productos SET activo=0 WHERE id=?";
		conexion.update(sql_update,id);
		
	}


	@Override
	public List<Productos> consultarProductos1() {
		// TODO Auto-generated method stub
		return null;
	}


}
