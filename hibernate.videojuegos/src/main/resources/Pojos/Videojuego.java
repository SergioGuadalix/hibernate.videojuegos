package Pojos;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
public class Videojuego {
	
	String nombre;
	long id;
	Videojuego_detalles detalles;
	private Set<Personaje>personajes;
	Set<Tienda> tiendas = new HashSet<Tienda>();
	 
	
	public Videojuego() {
		super();
	}
	
	public void addTienda (Tienda tienda) {
		this.tiendas.add(tienda);
	}

	public Videojuego(String nombre) {
		super();
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Id
	@GeneratedValue
	@Column
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@OneToOne(cascade = CascadeType.ALL)
	//@PrimaryKeyJoinColumn
	public Videojuego_detalles getDetalles() {
		return detalles;
	}

	public void setDetalles(Videojuego_detalles detalles) {
		this.detalles = detalles;
	}

	@OneToMany(mappedBy="videojuego", cascade = CascadeType.ALL)
	@OnDelete(action = OnDeleteAction.CASCADE)
	public Set<Personaje> getPersonajes() {
		return personajes;
	}

	public void setPersonajes(Set<Personaje> personajes) {
		this.personajes = personajes;
	}

	@ManyToMany(mappedBy="videojuegos")
	@OnDelete(action = OnDeleteAction.CASCADE)
	public Set<Tienda> getTiendas() {
		return tiendas;
	}

	public void setTiendas(Set<Tienda> tiendas) {
		this.tiendas = tiendas;
	} 
	
	
}
