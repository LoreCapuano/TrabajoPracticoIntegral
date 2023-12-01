package Vista;

import Controlador.ClienteControlador;
import Controlador.IncidenteControlador;

public class IncidenteVista {

	public static void main(String[] args) {
		IncidenteControlador incidenteControl= new IncidenteControlador();
		
		//LISTADO
				String incidenteLista= incidenteControl.listadoIncidente();
				System.out.println(incidenteLista.toString());
				
		//CREAR
			//String incidenteCreado=incidenteControl.crearIncidente(4, 1, "microcortes");
			//incidenteControl.toString();
			//System.out.println("------------\n"+incidenteCreado);

		//ELIMINAR
			//String incidenteEliminado=incidenteControl.eliminarIncidente(2);
			//System.out.println("------------\n"+incidenteEliminado);
		
		//ACTUALIZAR
		//String incidenteActualizado=incidenteControl.actualizarIncidente(1, 3, 3, "Se apaga la PC");
		//System.out.println("------------\n"+incidenteActualizado);
		
			//LEER UNO
			//String incidenteLeer=incidenteControl.leerIncidentes(1);
			//System.out.println("------------\n"+incidenteLeer);

	}

}
