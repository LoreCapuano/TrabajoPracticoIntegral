package Modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "clientes")

public class Cliente {
	
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	@Column (name="idCliente")
	private int idCliente;
	
	@Column (name= "nombre")
	private String nombre;
	
	@Column (name="apellido")
	private String apellido;
	
	@Column (name= "cuit")
	private String cuit;
	
	@Column (name="email")
	private String email;

	public Cliente(int idCliente, String nombre, String apellido, String cuit, String email) {
		this.idCliente = idCliente;
		this.nombre = nombre;
		this.apellido = apellido;
		this.cuit = cuit;
		this.email = email;
	}

	public Cliente() {
	}

	public Cliente(String nombre, String apellido, String cuit, String email) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.cuit = cuit;
		this.email = email;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCuit() {
		return cuit;
	}

	public void setCuit(String cuit) {
		this.cuit = cuit;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Cliente [idCliente=" + idCliente + ", nombre=" + nombre + ", apellido=" + apellido + ", cuit=" + cuit
				+ ", email=" + email + "]";
	}

	
	
}
