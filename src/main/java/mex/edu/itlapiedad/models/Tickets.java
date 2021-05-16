package mex.edu.itlapiedad.models;

import java.sql.Timestamp;

public class Tickets {
	
	private int id,activo,CAJERO_id;
	private float total;
	private Timestamp fecha_hora;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getActivo() {
		return activo;
	}
	public void setActivo(int activo) {
		this.activo = activo;
	}
	public int getCAJERO_id() {
		return CAJERO_id;
	}
	public void setCAJERO_id(int cAJERO_id) {
		CAJERO_id = cAJERO_id;
	}
	public float getTotal() {
		return total;
	}
	public void setTotal(float total) {
		this.total = total;
	}
	public Timestamp getFecha_hora() {
		return fecha_hora;
	}
	public void setFecha_hora(Timestamp fecha_hora) {
		this.fecha_hora = fecha_hora;
	}
	
	


}
