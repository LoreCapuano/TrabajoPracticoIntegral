package Controlador;



import jakarta.persistence.criteria.CriteriaQuery;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import Modelo.Incidente;

public class IncidenteControlador {

    public String crearIncidente(int idCliente, int idServicio, String descripcion) {

       SessionFactory sessionFactory= new 
    		   Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Incidente.class).buildSessionFactory();
    Session session=sessionFactory.openSession();
    try {
    	Incidente incidente=new Incidente (idCliente, idServicio, descripcion);
    	session.beginTransaction();
    	session.persist(incidente);
    	session.getTransaction().commit();
    	sessionFactory.close();
    	
    	return "Incidente creado satisfactoriamente \n-----------------------\n"+ incidente.toString();
    }catch (Exception e){
    	e.printStackTrace();
    }
    return "Error al intentar registrar incidente";
    }
    
    
    public String actualizarIncidente (int idIncidente, int idCliente, int idServicio, String descripcion) {
    	
    	SessionFactory sessionFactory= new 
     		   Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Incidente.class).buildSessionFactory();
     Session session=sessionFactory.openSession();
     try {
    	 session.beginTransaction();
    	 Incidente incidente=session.get(Incidente.class, idIncidente);
    	 incidente.setIdCliente(idCliente);
    	 incidente.setIdServicio(idServicio);
    	 incidente.setDescripcion(descripcion);
    	 session.persist (incidente);
    	 session.getTransaction().commit();
    	 sessionFactory.close();
    	 return "Servicio ID: "+ "actualizado en el sistema \n------------------\n"+ incidente.toString();
     }catch (Exception e){
    	 e.printStackTrace();
     }
     return "Error al intentar actualizar un incidente";
    }
    
    public String eliminarIncidente(int idIncidente) {
    	SessionFactory sessionFactory= new 
      		   Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Incidente.class).buildSessionFactory();
      Session session=sessionFactory.openSession();
    	try {
    		session.beginTransaction();
    		Incidente incidente=session.get(Incidente.class, idIncidente);
    		session.remove(incidente);
    		session.getTransaction().commit();
    		sessionFactory.close();
    		return "Incidente ID: "+ idIncidente+ "eliminado del sistema \n------------------\n";
    		
    	}catch (Exception e){
    		e.printStackTrace();
    	}
    	return "Error al intentar eliminar un Incidente";
    }
    
    public String leerIncidentes(int idIncidente) {
    	SessionFactory sessionFactory= new
    			Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Incidente.class).buildSessionFactory();
    	Session session=sessionFactory.openSession();
    	try {
    		session.beginTransaction();
    		Incidente incidente=session.get(Incidente .class,idIncidente);
    		session.getTransaction().commit();
    		sessionFactory.close();
    		return " Incidente ID: "+ idIncidente + ": "+ incidente.toString();
    	}catch (Exception e){
    		e.printStackTrace();
    	}
    	return "Error al intentar leer Incidente";
    }
    public String listadoIncidente() {
SessionFactory sessionFactory= new
Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Incidente.class).buildSessionFactory();
Session session=sessionFactory.openSession();
    try {
    	session.beginTransaction();
    	CriteriaQuery<Incidente>cq=session.getCriteriaBuilder().createQuery(Incidente.class);
    	cq.from(Incidente.class);
    	List<Incidente> incidente=session.createQuery(cq).getResultList();
    	
    	System.out.println("");
    	System.out.println("L I S T A  D E  I N C I D E N T E S \n---------------------------\n");
    	for (Incidente u:incidente) {
    		System.out.println("NOMBRE: "+ u + "\n");
    		System.out.println("ID: "+u.getIdIncidente());
    		System.out.println("ID CLIENTE: "+u.getIdCliente());
    		System.out.println("ID SERVICIO: "+u.getIdServicio());
    		System.out.println("DESCRIPCION: "+u.getDescripcion()+"\n---------------\n");
    		
    	}
    	sessionFactory.close();
    }catch (Exception e){
    	e.printStackTrace();
    	return "Error al intentar obtener lista de Incidentes";
    }
    return "Fin del listado";
    }  
}