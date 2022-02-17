package Pojos;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Personaje {

	long id;
	String nombre;
	String arma;
	Videojuego videojuego;
	
	public Personaje() {
		super();
	}

	public Personaje(String nombre, String arma, Videojuego videojuego) {
		super();
		this.nombre = nombre;
		this.arma = arma;
		this.videojuego=videojuego;
	}

	@Id
	@GeneratedValue
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getArma() {
		return arma;
	}

	public void setArma(String arma) {
		this.arma = arma;
	}
	@ManyToOne
	public Videojuego getVideojuego() {
		return videojuego;
	}

	public void setVideojuego(Videojuego videojuego) {
		this.videojuego = videojuego;
	}
	
	
	
}
