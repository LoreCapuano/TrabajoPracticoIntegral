package PrincipalMain;

import java.time.LocalDate;
import java.util.Scanner;

import Controlador.*;

public class Principal {

	public static void main(String[] args) {
		try (Scanner sc=new Scanner (System.in)){
			ClienteControlador clienteControl = new ClienteControlador();
			TecnicoControlador tecnicoControl = new TecnicoControlador();
			IncidenteControlador incidenteControl = new IncidenteControlador();
			ServicioControlador servicioControl=new ServicioControlador();
			
			char option;
			String MenageOption= "\n\n M E N U: "+ "\n-----------------\n"
			+"1- Crear Tecnico \n"
			+"2- Crear Servicio \n"
			+"3- Crear Cliente \n"
			+"4 - Alta Incidente \n"
			+"5 -Listado Tecnicos \n"
			+"6 - Listado Servicios \n"
			+"7 -Listado Incidentes \n"
			+"8 - Listado Clientes \n"
			+"9 - Salir";
			
			while (true) {
				System.out.println(MenageOption);
				option=sc.next().charAt(0);
				switch (option) {
				case '1': System.out.println("Creando Tecnico: "); tecnicoControl.crearTecnico("Ramiro", "Cuesta", "Aplicaciones web");break;
				case '2': System.out.println("Creando Servicio"); servicioControl.crearServicio("Dolphin");break;
				case '3': System.out.println("Creando Cliente"); clienteControl.crearCliente("Carla", "Rocha", "27245653231", "carli@gmail.com");break;
				case '4':System.out.println("Creando Incidente");incidenteControl.crearIncidente(3, 7, "NO sabe");break;
				case '5':System.out.println("LISTADO DE TECNICOS");tecnicoControl.listadoTecnicos();break;
				case '6':System.out.println("LISTADO DE SERVICIOS");servicioControl.listadoServicios();break;
				case '7':System.out.println("LISTADO DE INCIDENTES");incidenteControl.listadoIncidente();break;
				case '8':System.out.println("LISTADO DE CLIENTES");clienteControl.listadoClientes();break;
				case '9':System.out.println("\n ");System.out.println("S A L I D A  D E L  S I S T E M A");System.exit(0);break;
				default: System.out.println("\n "); System.out.println("Opción de menu no válida");break;
				}
			}
		}
				 
	}

}
