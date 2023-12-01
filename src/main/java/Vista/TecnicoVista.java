package Vista;

import Controlador.TecnicoControlador;

public class TecnicoVista {

	public static void main(String[] args) {
		TecnicoControlador tecnicoControl=new TecnicoControlador();
		
		//LISTADO
				//String tecnicoLista= tecnicoControl.listadoTecnicos();
				//System.out.println(tecnicoLista.toString());
				
		//CREAR
			//String tecnicoCreado=tecnicoControl.crearTecnico("Sebastian", "Peralta", "Soporte Tecnico");	
			//tecnicoControl.toString();
			//System.out.println("------------\n"+tecnicoCreado);

		//ELIMINAR
			//String tecnicoEliminado=tecnicoControl.eliminarTecnico(6);
			//System.out.println("------------\n"+tecnicoEliminado);

		//ACTUALIZAR
			//String tecnicoActualizado=tecnicoControl.actualizarTecnico(3, "Maximiliano","Peralta", "redes")	;
			//System.out.println("------------\n"+tecnicoActualizado);
		
				//LEER UNO
			String tecnicoLeer=tecnicoControl.leerTecnico(3);
			System.out.println("------------\n"+tecnicoLeer);
	}

}
