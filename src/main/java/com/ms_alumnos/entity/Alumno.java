package com.ms_alumnos.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "Alumnos")
public class Alumno implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "aid_auto")
	@SequenceGenerator(name = "aid_auto", sequenceName = "ALUMNOS_SEQ", allocationSize = 1)
	@Column(name = "ALUMNO_ID", columnDefinition = "NUMBER")
	private int alumnoID;
	
	@Column(name = "NOMBRE", columnDefinition = "NVARCHAR2(50)")
	private String nombre;
	
	@Column(name = "FECHA_NACIMIENTO", columnDefinition = "DATE")
	private LocalDateTime fechaNacimiento;
	
	@Column(name = "GENERO", columnDefinition = "NVARCHAR2(20)")
	private String genero;
	
	@Column(name = "GRADO", columnDefinition = "NVARCHAR2(30)")
	private String grado;
	
	@Column(name = "DIRECCION", columnDefinition = "NVARCHAR2(50)")
	private String ciudad;
	
	@Column(name = "STATUS", columnDefinition = "NUMBER")
	private int status;

	public Alumno() {
		super();
		
	}

	public int getAlumnoID() {
		return alumnoID;
	}

	public void setAlumnoID(int alumnoID) {
		this.alumnoID = alumnoID;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public LocalDateTime getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDateTime fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getGrado() {
		return grado;
	}

	public void setGrado(String grado) {
		this.grado = grado;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
