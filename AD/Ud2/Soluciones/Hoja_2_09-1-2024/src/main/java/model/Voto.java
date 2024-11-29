package model;

import java.io.Serializable;
import jakarta.persistence.*;


/**
 * The persistent class for the votos database table.
 * 
 */
@Entity
@Table(name="votos")
@NamedQuery(name="Voto.findAll", query="SELECT v FROM Voto v")
public class Voto implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private VotoPK id;

	//uni-directional many-to-one association to Cancion
	@ManyToOne
	@JoinColumn(name="cancion")
	private Cancion cancion;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="usuario", referencedColumnName="user",insertable = false,updatable = false)
	private Usuario usuarioBean;

	public Voto() {
	}

	public VotoPK getId() {
		return this.id;
	}

	public void setId(VotoPK id) {
		this.id = id;
	}

	public Cancion getCancion() {
		return this.cancion;
	}

	public void setCancion(Cancion cancion) {
		this.cancion = cancion;
	}

	public Usuario getUsuarioBean() {
		return this.usuarioBean;
	}

	public void setUsuarioBean(Usuario usuarioBean) {
		this.usuarioBean = usuarioBean;
	}

}