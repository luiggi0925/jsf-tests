package edu.ltmj.view.bean;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.context.RequestContext;

import edu.ltmj.domain.Equipo;
import edu.ltmj.domain.EquipoDetalle;

@ManagedBean
@ViewScoped
public class EquipoBean implements Serializable {

	private List<Equipo> equiposList;
	private List<Map<String, Object>> equipoDecoradoList;
	private String nombreEquipoDetalle;
	private String placa;

	private Map<String, Object> equipoSeleccionado;

	public EquipoBean() {
		
	}

	@PostConstruct
	public void init() {
		equiposList = new ArrayList<>(
				asList(
					new Equipo(1, "Los Buitres", new ArrayList<>(asList(new EquipoDetalle("Buitre 1", "ABCDEFG")))),
					new Equipo(2, "Los Halcones", new ArrayList<>(asList(new EquipoDetalle("Halcón 1", "lolol"), new EquipoDetalle("Halcón 2", "roflmao"))))
				)
			);
//		final int[] contador = { 0 };
//		equipoDecoradoList = equiposList.stream()
//			.map(equipo -> {
//				Map<String, Object> map = new HashMap<>();
//				map.put("index", contador[0]++);
//				map.put("equipo", equipo);
//				return map;
//			})
//			.collect(toList());
		equipoDecoradoList = new ArrayList<>();
		int index = 0;
		for (Equipo equipo : equiposList) {
			Map<String, Object> map = new HashMap<>();
			map.put("index", index++);
			map.put("equipo", equipo);
			equipoDecoradoList.add(map);
		}
		nombreEquipoDetalle = "";
		placa = "";
	}

	public List<Equipo> getEquiposList() {
		return equiposList;
	}

	public void setEquiposList(List<Equipo> equiposList) {
		this.equiposList = equiposList;
	}

	public List<Map<String, Object>> getEquipoDecoradoList() {
		return equipoDecoradoList;
	}

	public void setEquipoDecoradoList(List<Map<String, Object>> equipoDecoradoList) {
		this.equipoDecoradoList = equipoDecoradoList;
	}

	public String getNombreEquipoDetalle() {
		return nombreEquipoDetalle;
	}

	public void setNombreEquipoDetalle(String nombreEquipoDetalle) {
		this.nombreEquipoDetalle = nombreEquipoDetalle;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public Map<String, Object> getEquipoSeleccionado() {
		return equipoSeleccionado;
	}

	public void setEquipoSeleccionado(Map<String, Object> equipoSeleccionado) {
		this.equipoSeleccionado = equipoSeleccionado;
	}

	public void registarEquipoDetalle() {
		Equipo equipo = (Equipo)equipoSeleccionado.get("equipo");
		equipo.getEquipoDellateList().add(new EquipoDetalle(nombreEquipoDetalle, placa));
		RequestContext.getCurrentInstance().update("nuevoItem");
		RequestContext.getCurrentInstance().update(String.format("equipos:%d:equipoDetalleTable", equipoSeleccionado.get("index")));
		nombreEquipoDetalle = "";
		placa = "";
		equipoSeleccionado = null;
	}
}
