package Pojos;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Tienda {

	long id;
	String nombre;
	Set<Videojuego> videojuegos = new HashSet<Videojuego>();
	
	public Tienda() {
		super();
	}

	public Tienda(String nombre) {
		super();
		this.nombre = nombre;
	}
	
	public void addVideojuego(Videojuego videojuego) {
		this.videojuegos.add(videojuego);
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

	@ManyToMany(cascade=CascadeType.ALL)
	public Set<Videojuego> getVideojuegos() {
		return videojuegos;
	}

	public void setVideojuegos(Set<Videojuego> videojuegos) {
		this.videojuegos = videojuegos;
	}
	
	
}
