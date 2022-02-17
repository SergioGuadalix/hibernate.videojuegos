package Pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
public class Videojuego_detalles {

	long id;
	float precio;
	String desarrolladora;
	Videojuego videojuego;
	
	public Videojuego_detalles(float precio, String desarrolladora) {
		super();
		this.precio = precio;
		this.desarrolladora = desarrolladora;
	}

	public Videojuego_detalles() {
		super();
	}

	@Id
	@GeneratedValue(generator = "foreigngen")
	//@GenericGenerator(name="foreigngen",strategy="foreign", parameters = @Parameter(name="property",value="videojuego"))
	@Column
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public String getDesarrolladora() {
		return desarrolladora;
	}

	public void setDesarrolladora(String desarrolladora) {
		this.desarrolladora = desarrolladora;
	}

	@OneToOne(mappedBy = "detalles")
	public Videojuego getVideojuego() {
		return videojuego;
	}

	public void setVideojuego(Videojuego videojuego) {
		this.videojuego = videojuego;
	}
	
	
	
}
