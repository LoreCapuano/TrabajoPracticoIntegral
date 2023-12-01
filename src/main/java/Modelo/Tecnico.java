package Modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "tecnico")

public class Tecnico {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name="idTecnico")
	private int idTecnico;
	@Column(name="nombre")
	private String nombre;
	@Column(name="apellido")
	private String apellido;
	@Column(name="especialidad")
	private String especialidad;

	/*public Tecnico(int idTecnico, String nombre, String apellido, String especialidad) {
		this.idTecnico = idTecnico;
		this.nombre = nombre;
		this.apellido = apellido;
		this.especialidad = especialidad;
	}*/

	public Tecnico() {
	}

	public Tecnico(String nombre, String apellido, String especialidad) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.especialidad = especialidad;
	}

	public int getIdTecnico() {
		return idTecnico;
	}

	public void setIdTecnico(int idTecnico) {
		this.idTecnico = idTecnico;
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

	public String getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}

	@Override
	public String toString() {
		return "Tecnico [idTecnico=" + idTecnico + ", nombre=" + nombre + ", apellido=" + apellido + ", especialidad="
				+ especialidad + "]";
	}

}
