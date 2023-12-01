package Modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "incidentes")

public class Incidente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idIncidente")
	private int idIncidente;
	
	@Column(name = "idCliente")
	private int idCliente;
	
	@Column(name = "idServicio")
	private int idServicio;
	
	@Column(name = "descirpcion")
	private String descripcion;

	/*
	 * @Column (name="fechaApertura") private Date fechaApertura;
	 * 
	 * @Column (name="fechaResolucion") private Date fechaResolucion;
	 */

	public Incidente(int idIncidente, int idCliente, int idServicio, String descripcion) {
		this.idIncidente = idIncidente;
		this.idCliente = idCliente;
		this.idServicio = idServicio;
		this.descripcion = descripcion;
	}

	public Incidente(int idCliente, int idServicio, String descripcion) {
		this.idCliente = idCliente;
		this.idServicio = idServicio;
		this.descripcion = descripcion;
	}

	public Incidente() {
	}

	public int getIdIncidente() {
		return idIncidente;
	}

	public void setIdIncidente(int idIncidente) {
		this.idIncidente = idIncidente;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public int getIdServicio() {
		return idServicio;
	}

	public void setIdServicio(int idServicio) {
		this.idServicio = idServicio;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "Incidente [idIncidente=" + idIncidente + ", idCliente=" + idCliente + ", idServicio=" + idServicio
				+ ", descripcion=" + descripcion + "]";
	}

}
