package edu.ltmj.domain;

import java.io.Serializable;
import java.util.List;

public class Equipo implements Serializable {

	private int id;
	private String nombre;
	private List<EquipoDetalle> equipoDellateList;

	public Equipo() {

	}

	public Equipo(int id, String nombre, List<EquipoDetalle> equipoDellateList) {
		this.id = id;
		this.nombre = nombre;
		this.equipoDellateList = equipoDellateList;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<EquipoDetalle> getEquipoDellateList() {
		return equipoDellateList;
	}

	public void setEquipoDellateList(List<EquipoDetalle> equipoDellateList) {
		this.equipoDellateList = equipoDellateList;
	}
}