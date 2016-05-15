package edu.ltmj.domain;

import java.io.Serializable;

public class EquipoDetalle implements Serializable {

	private String nombre;
	private String placa;

	public EquipoDetalle() {
	}

	public EquipoDetalle(String nombre, String placa) {
		this.nombre = nombre;
		this.placa = placa;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}
}
