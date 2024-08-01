package com.ms_alumnos.service;

import java.util.List;

import com.ms_alumnos.entity.Alumno;
import com.ms_alumnos.exception.NoSePuedeEditarException;
import com.ms_alumnos.request.AlumnoRequest;

public interface AlumnoService {

	public Alumno guardar(AlumnoRequest request); 
	
	public Alumno editar(AlumnoRequest request) throws NoSePuedeEditarException;  
	
	public Alumno buscar(int id);
	
	public String eliminar(int id);
	
	public String cambiarStatus(int id);
	
	public List<Alumno> mostrar();
}
