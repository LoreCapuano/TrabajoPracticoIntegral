package Controlador;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import Modelo.Cliente;
import Modelo.Incidente;
import Modelo.Tecnico;
import jakarta.persistence.criteria.CriteriaQuery;

public class ClienteControlador {
	
	public String crearCliente (String nombre, String apellido, String cuit, String email) {
		SessionFactory sessionFactory= new 
	    		   Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Cliente.class).buildSessionFactory();
	    Session session=sessionFactory.openSession();
	    try {
	    	Cliente cliente=new Cliente (nombre, apellido, cuit, email);
	    	session.beginTransaction();
	    	session.persist(cliente);
	    	session.getTransaction().commit();
	    	sessionFactory.close();
	    	return "Cliente creado satisfactoriamente \n----------------\n" + cliente.toString();
	    }catch (Exception e){
	    	e.printStackTrace();
	    }
	    return "Error al intenar registrar un Tecnico";
	}
	
	public String actualizarCliente(int idCliente, String nombre, String apellido, String cuit, String email) {
		SessionFactory sessionFactory= new 
	    		   Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Cliente.class).buildSessionFactory();
	    Session session=sessionFactory.openSession();
	    try {
	    	session.beginTransaction();
	    	Cliente cliente=session.get(Cliente.class, idCliente);
	    	cliente.setNombre(nombre);
	    	cliente.setApellido(apellido);
	    	cliente.setCuit(cuit);
	    	cliente.setEmail(email);
	    	session.persist(cliente);
	    	session.getTransaction().commit();
	    	sessionFactory.close();
	    	return "Cliente ID: "+ idCliente + " actualizado en el Sistema \n-----------------\n"+ cliente.toString();
	    }catch (Exception e){
	    	e.printStackTrace();
	    }
	    return "Error al intentar actualizar Cliente";	    
	}
	
	public String eliminarCliente(int idCliente) {
		SessionFactory sessionFactory= new 
	    		   Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Cliente.class).buildSessionFactory();
	    Session session=sessionFactory.openSession();
	    try {
	    	session.beginTransaction();
	    	Cliente cliente= session.get(Cliente.class,idCliente);
	    	session.remove(cliente);
	    	session.getTransaction().commit();
	    	sessionFactory.close();
	    	return "Cliente ID: "+ idCliente + " eliminado del sistema \n-------------------\n";
	    }catch (Exception e){
	    	e.printStackTrace();
	    }
	    return "Error al intentar eliminar al Cliente";
	}
	
	public String leerCliente(int idCliente) {
		SessionFactory sessionFactory= new 
	    		   Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Cliente.class).buildSessionFactory();
	    Session session=sessionFactory.openSession();
	    try {
	    	session.beginTransaction();
	    	Cliente cliente=session.get(Cliente.class,idCliente);
	    	session.getTransaction().commit();
	    	sessionFactory.close();
	    	return "Cliente ID: "+ idCliente + ": "+cliente.toString();
	    }catch (Exception e){
	    	e.printStackTrace();	    	
	    }
	    return "Error al intentar leer el Cliente";
	}
	
	 public String listadoClientes() {
		 SessionFactory sessionFactory= new
		 Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Cliente.class).buildSessionFactory();
		 Session session=sessionFactory.openSession();
		     try {
		     	session.beginTransaction();
		     	CriteriaQuery<Cliente>cq=session.getCriteriaBuilder().createQuery(Cliente.class);
		     	cq.from(Cliente.class);
		     	List<Cliente> cliente=session.createQuery(cq).getResultList();
		     	
		     	System.out.println("");
		     	System.out.println("L I S T A  D E  C L I E N T E S  \n---------------------------\n");
		     	for (Cliente u:cliente) {
		     		System.out.println("NOMBRE: "+ u + "\n");
		     		System.out.println("ID: "+u.getIdCliente());
		     		System.out.println("NOMBRE: "+u.getNombre()+"\n---------------\n");
		     		System.out.println("APELLIDO: "+u.getApellido()+"\n---------------\n");
		     		System.out.println("CUIT: "+u.getCuit()+"\n---------------\n");
		     		System.out.println("EMAIL: "+u.getEmail()+"\n---------------\n");
		     		
		     	}
		     	sessionFactory.close();
		     }catch (Exception e){
		     	e.printStackTrace();
		     	return "Error al intentar obtener lista de Clientes";
		     }
		     return "Fin del listado";
		     }  
}
