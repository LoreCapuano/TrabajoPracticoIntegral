package Controlador;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import Modelo.Cliente;
import Modelo.Tecnico;
import jakarta.persistence.criteria.CriteriaQuery;

public class TecnicoControlador {

	public String crearTecnico (String nombre, String apellido, String especialidad) {
		SessionFactory sessionFactory= new 
	    		   Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Tecnico.class).buildSessionFactory();
	    Session session=sessionFactory.openSession();
	    try {
	    	Tecnico tecnico=new Tecnico (nombre, apellido, especialidad);
	    	session.beginTransaction();
	    	session.persist(tecnico);
	    	session.getTransaction().commit();
	    	sessionFactory.close();
	    	return "Tecnico creado satisfactoriamente \n----------------\n" + tecnico.toString();
	    }catch (Exception e){
	    	e.printStackTrace();
	    }
	    return "Error al intenar registrar un Tecnico";
	}
	
	public String actualizarTecnico(int idTecnico, String nombre, String apellido, String especialidad) {
		SessionFactory sessionFactory= new 
	    		   Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Tecnico.class).buildSessionFactory();
	    Session session=sessionFactory.openSession();
	    try {
	    	session.beginTransaction();
	    	Tecnico tecnico=session.get(Tecnico.class, idTecnico);
	    	tecnico.setNombre(nombre);
	    	tecnico.setApellido(apellido);
	    	tecnico.setEspecialidad(especialidad);
	    	session.persist(tecnico);
	    	session.getTransaction().commit();
	    	sessionFactory.close();
	    	return "Tecnico ID: "+ idTecnico + " actualizado en el Sistema \n-----------------\n"+ tecnico.toString();
	    }catch (Exception e){
	    	e.printStackTrace();
	    }
	    return "Error al intentar actualizar Tecnico";	    
	}
	
	public String eliminarTecnico(int idTecnico) {
		SessionFactory sessionFactory= new 
	    		   Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Tecnico.class).buildSessionFactory();
	    Session session=sessionFactory.openSession();
	    try {
	    	session.beginTransaction();
	    	Tecnico tecnico= session.get(Tecnico.class,idTecnico);
	    	session.remove(tecnico);
	    	session.getTransaction().commit();
	    	sessionFactory.close();
	    	return "Tecnico ID: "+ idTecnico + " eliminado del sistema \n-------------------\n";
	    }catch (Exception e){
	    	e.printStackTrace();
	    }
	    return "Error al intentar eliminar al Tecnico";
	}
	
	public String leerTecnico(int idTecnico) {
		SessionFactory sessionFactory= new 
	    		   Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Tecnico.class).buildSessionFactory();
	    Session session=sessionFactory.openSession();
	    try {
	    	session.beginTransaction();
	    	Tecnico tecnico=session.get(Tecnico.class,idTecnico);
	    	session.getTransaction().commit();
	    	sessionFactory.close();
	    	return "Tecnico ID: "+ idTecnico+ ": "+ tecnico.toString();
	    }catch (Exception e){
	    	e.printStackTrace();	    	
	    }
	    return "Error al intentar leer el Tecnico";
	}
	
	public String listadoTecnicos() {
		 SessionFactory sessionFactory= new
		 Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Tecnico.class).buildSessionFactory();
		 Session session=sessionFactory.openSession();
		     try {
		     	session.beginTransaction();
		     	CriteriaQuery<Tecnico>cq=session.getCriteriaBuilder().createQuery(Tecnico.class);
		     	cq.from(Tecnico.class);
		     	List<Tecnico> tecnico=session.createQuery(cq).getResultList();
		     	
		     	System.out.println("");
		     	System.out.println("L I S T A  D E  T E C N I C O S  \n---------------------------\n");
		     	for (Tecnico u:tecnico) {
		     		System.out.println("NOMBRE: "+ u + "\n");
		     		System.out.println("ID: "+u.getIdTecnico());
		     		System.out.println("NOMBRE: "+u.getNombre());
		     		System.out.println("APELLIDO: "+u.getApellido());
		     		System.out.println("CUIT: "+u.getEspecialidad()+"\n---------------\n");
		     		
		     		
		     	}
		     	sessionFactory.close();
		     }catch (Exception e){
		     	e.printStackTrace();
		     	return "Error al intentar obtener lista de Tecnicos";
		     }
		     return "Fin del listado";
		     }  
}
