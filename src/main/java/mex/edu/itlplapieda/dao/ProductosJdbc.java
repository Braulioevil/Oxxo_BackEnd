package mex.edu.itlplapieda.dao;

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

import mex.edu.itlplapieda.models.Productos;

@Repository
public class ProductosJdbc implements ProductosDao {

	@Autowired
	JdbcTemplate conexion;
	
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
		productos.setId(id.intValue());
		return productos;
	}

	@Override
	public List<Productos> consultarProductos() {
		// TODO Auto-generated method stub
		return null;
	}
}
