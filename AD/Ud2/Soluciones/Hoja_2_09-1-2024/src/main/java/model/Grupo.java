package model;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the grupos database table.
 * 
 */
@Entity
@Table(name="grupos")
@NamedQuery(name="Grupo.findAll", query="SELECT g FROM Grupo g")
public class Grupo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int codgrupo;

	private int annoGrab;

	private String compania;

	private byte esgrupo;

	private String estilo;

	
	private LocalDate fechaEstreno;

	private String localidad;

	private String nombre;
	@OneToMany(mappedBy = "grupo",fetch = FetchType.LAZY)
	private List<Componente> componentes=new ArrayList<>();

	@OneToMany(mappedBy = "grupo")
	private List<Cancion> canciones=new ArrayList<>();
	public Grupo() {
	}

	public int getCodgrupo() {
		return this.codgrupo;
	}

	public void setCodgrupo(int codgrupo) {
		this.codgrupo = codgrupo;
	}

	public int getAnnoGrab() {
		return this.annoGrab;
	}

	public void setAnnoGrab(int annoGrab) {
		this.annoGrab = annoGrab;
	}

	public String getCompania() {
		return this.compania;
	}

	public void setCompania(String compania) {
		this.compania = compania;
	}

	public byte getEsgrupo() {
		return this.esgrupo;
	}

	public void setEsgrupo(byte esgrupo) {
		this.esgrupo = esgrupo;
	}

	public String getEstilo() {
		return this.estilo;
	}

	public void setEstilo(String estilo) {
		this.estilo = estilo;
	}

	public LocalDate getFechaEstreno() {
		return this.fechaEstreno;
	}

	public void setFechaEstreno(LocalDate fechaEstreno) {
		this.fechaEstreno = fechaEstreno;
	}

	public String getLocalidad() {
		return this.localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Componente> getComponentes() {
		return componentes;
	}

	public void setComponentes(List<Componente> componentes) {
		this.componentes = componentes;
	}

	public List<Cancion> getCanciones() {
		return canciones;
	}

	public void setCanciones(List<Cancion> canciones) {
		this.canciones = canciones;
	}

	
}