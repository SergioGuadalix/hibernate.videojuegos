package Pojos;
/**
 * Autor: Sergio Guadalix Romero
 */
import java.text.ParseException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Query;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class Main {

	public static void main(String[] args) throws ParseException, SecurityException, RollbackException, HeuristicMixedException, HeuristicRollbackException, SystemException {
		// crear la conexión
		Configuration configuration = new Configuration().configure();
		StandardServiceRegistryBuilder registry = new StandardServiceRegistryBuilder();
		registry.applySettings(configuration.getProperties());
		registry.build();

		SessionFactory sessionFactory = configuration.buildSessionFactory();

		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		//Se crean videojuegos y detalles
		Videojuego videojuego1 = new Videojuego("God of War");
		Videojuego videojuego2 = new Videojuego("Kingdom Hearts");
		
		Videojuego_detalles detalles1 = new Videojuego_detalles(60, "Ubisoft");
		Videojuego_detalles detalles2 = new Videojuego_detalles(50, "Square Enix");
		
		videojuego1.setDetalles(detalles1);
		videojuego2.setDetalles(detalles2);
		detalles1.setVideojuego(videojuego1);
		detalles1.setVideojuego(videojuego2);
		
		//Se crean personajes y se setan al videojuego
		Personaje personaje1 = new Personaje("Kratos", "Espadas del Caos", videojuego1);
		Personaje personaje2 = new Personaje("Atreus", "Arco", videojuego1);
		Personaje personaje3 = new Personaje("Sora", "Llave Espada", videojuego2);
		Personaje personaje4 = new Personaje("Riku", "Llave Espada oscura", videojuego2);
		
		/*
		 * Set<Personaje> personajes1 = new HashSet<Personaje>(); Set<Personaje>
		 * personajes2 = new HashSet<Personaje>(); personajes1.add(personaje1);
		 * personajes1.add(personaje2); personajes2.add(personaje3);
		 * personajes2.add(personaje4);
		 */
		
		//videojuego1.setPersonajes(personajes1);
		//videojuego2.setPersonajes(personajes2);
		
		Tienda tienda1 = new Tienda("Game");
		Tienda tienda2 = new Tienda("Fnac");
		
		tienda1.addVideojuego(videojuego2);
		tienda2.addVideojuego(videojuego1);
		videojuego1.addTienda(tienda2);
		videojuego2.addTienda(tienda1);
		
		session.save(videojuego1);
		session.save(videojuego2);
		session.save(personaje4);
		session.save(personaje1);
		session.save(personaje2);
		session.save(personaje3);
		session.save(tienda1);
		session.save(tienda2);
		

		
		session.getTransaction().commit();
		
		//Borre un departamento.
		
		  org.hibernate.Transaction t3 = session.beginTransaction(); Query q15 =
		  session.
		  createNativeQuery("delete from videojuego where videojuego.nombre = 'God of War'"
		  ); int rowsAffected3 = q15.executeUpdate(); t3.commit(); if (rowsAffected3 >
		  0) { Query q16 = session.
		  createNativeQuery("SELECT videojuego.nombre, videojuego.id FROM videojuegos.videojuego"
		  ); List<Object[]> datos_nuevos_departamento = q16.getResultList();
		  System.out.println(""); System.out.println(""); for (Object[]
		  nuevo_departamento: datos_nuevos_departamento) {
		  System.out.println("Departamento:  "+ nuevo_departamento[0]+
		  ". --> Id del departamento: "+ nuevo_departamento[1]+" ."); }
		  System.out.println(""); System.out.println(""); }
		 
		session.close();
	}
		

}