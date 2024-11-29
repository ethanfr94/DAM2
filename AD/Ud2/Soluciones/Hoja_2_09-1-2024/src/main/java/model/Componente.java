package model;

import java.io.Serializable;
import jakarta.persistence.*;


/**
 * The persistent class for the componentes database table.
 * 
 */
@Entity
@Table(name="componentes")
@NamedQuery(name="Componente.findAll", query="SELECT c FROM Componente c")
public class Componente implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	private int idComp;
	private String alias;

	private String apellido;

	private String funcion;


	private String nombre;

	//uni-directional many-to-one association to Grupo
	@ManyToOne
	@JoinColumn(name="grupo")
	private Grupo grupo;

	public Componente() {
	}

	public String getAlias() {
		return this.alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getApellido() {
		return this.apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getFuncion() {
		return this.funcion;
	}

	public void setFuncion(String funcion) {
		this.funcion = funcion;
	}

	public int getIdComp() {
		return this.idComp;
	}

	public void setIdComp(int idComp) {
		this.idComp = idComp;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Grupo getGrupo() {
		return this.grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}

}