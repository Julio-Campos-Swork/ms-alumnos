package com.ms_alumnos.request;

import java.time.LocalDateTime;

public class AlumnoRequest {

	// POJO - Plain Old Java Object
	// valida informacion del exterior antes de guardarla o persistirla en BD
	private int alumnoID;
	private String nombre;
	private LocalDateTime fechaNacimiento;
	private String genero;
	private String grado;
	private String ciudad;
	private int status;

	public AlumnoRequest() {
		super();
	}

	public AlumnoRequest(int alumnoID, String nombre, LocalDateTime fechaNacimiento, String genero, String grado,
			int status) {
		super();
		this.alumnoID = alumnoID;
		this.nombre = nombre;
		this.fechaNacimiento = fechaNacimiento;
		this.genero = genero;
		this.grado = grado;
		this.status = status;
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

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	
	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	@Override
	public String toString() {
		return "AlumnoRequest [alumnoID=" + alumnoID + ", nombre=" + nombre + ", fechaNacimiento=" + fechaNacimiento
				+ ", genero=" + genero + ", grado=" + grado + ", ciudad=" + ciudad + ", status=" + status + "]";
	}

	

}
