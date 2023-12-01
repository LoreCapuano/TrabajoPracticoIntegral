package Controlador;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import Modelo.Servicio;
import Modelo.Tecnico;
import jakarta.persistence.criteria.CriteriaQuery;

public class ServicioControlador {

	public String crearServicio(String nombre) {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Servicio.class).buildSessionFactory();
		Session session = sessionFactory.openSession();
		try {
			Servicio servicio = new Servicio(nombre);
			session.beginTransaction();
			session.persist(servicio);
			session.getTransaction().commit();
			sessionFactory.close();
			return "Servicio creado satisfactoriamente \n----------------\n" + servicio.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Error al intenar registrar un Servicio";
	}

	public String actualizarServicio(int idServicio, String nombre) {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Servicio.class).buildSessionFactory();
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			Servicio servicio = session.get(Servicio.class, idServicio);
			servicio.setNombre(nombre);
			session.persist(servicio);
			session.getTransaction().commit();
			sessionFactory.close();
			return "Servicio ID: " + idServicio + " actualizado en el Sistema \n-----------------\n"
					+ servicio.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Error al intentar actualizar Servicio";
	}

	public String eliminarServicio(int idServicio) {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Servicio.class).buildSessionFactory();
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			Servicio servicio = session.get(Servicio.class, idServicio);
			session.remove(servicio);
			session.getTransaction().commit();
			sessionFactory.close();
			return "Servicio ID: " + idServicio + " eliminado del sistema \n-------------------\n";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Error al intentar eliminar Servicio";
	}

	public String leerServicio(int idServicio) {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Servicio.class).buildSessionFactory();
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			Servicio servicio = session.get(Servicio.class, idServicio);
			session.getTransaction().commit();
			sessionFactory.close();
			return "Servicio ID: " + idServicio + ": " + servicio.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Error al intentar leer el Servicio";
	}

	public String listadoServicios() {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Servicio.class).buildSessionFactory();
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			CriteriaQuery<Servicio> cq = session.getCriteriaBuilder().createQuery(Servicio.class);
			cq.from(Servicio.class);
			List<Servicio> servicio = session.createQuery(cq).getResultList();

			System.out.println("");
			System.out.println("L I S T A  D E  S E R V I C I O S   \n---------------------------\n");
			for (Servicio u : servicio) {
				System.out.println("NOMBRE: " + u + "\n");
				System.out.println("ID: " + u.getIdServicio());
				System.out.println("NOMBRE: " + u.getNombre() + "\n---------------\n");

			}
			sessionFactory.close();
		} catch (Exception e) {
			e.printStackTrace();
			return "Error al intentar obtener lista de Servicios";
		}
		return "Fin del listado";
	}

}
