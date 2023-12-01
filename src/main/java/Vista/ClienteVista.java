
package Vista;

import Controlador.ClienteControlador;

public class ClienteVista {

	public static void main(String[] args) {
		
		ClienteControlador clienteControl= new ClienteControlador();
		
//LISTADO
		//String clienteLista= clienteControl.listadoClientes();
		//System.out.println(clienteLista.toString());
		
//CREAR
	//String clienteCreado=clienteControl.crearCliente("Gustavo", "Paccusse", "20232611010", "gptramites2019@hotmail.com");	
	//clienteControl.toString();
	//System.out.println("------------\n"+clienteCreado);

//ELIMINAR
	//String clienteEliminado=clienteControl.eliminarCliente(2);
	//System.out.println("------------\n"+clienteEliminado);

//ACTUALIZAR
	String clienteActualizado=clienteControl.actualizarCliente(1, "Lorena P", "Capuano", "27268003725", "lorecp@gmail.com");	
	System.out.println("------------\n"+clienteActualizado);
//LEER UNO
	//String clienteLeer=clienteControl.leerCliente(3);
	//System.out.println("------------\n"+clienteLeer);
	
	
	
	}

}
