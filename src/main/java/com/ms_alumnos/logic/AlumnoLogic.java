package com.ms_alumnos.logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ms_alumnos.entity.Alumno;
import com.ms_alumnos.exception.NoSePuedeEditarException;
import com.ms_alumnos.repository.AlumnoRepository;
import com.ms_alumnos.request.AlumnoRequest;
import com.ms_alumnos.service.AlumnoService;

@Service
public class AlumnoLogic implements AlumnoService {

	// Dependencies injection

	@Autowired
	AlumnoRepository dao;

	@Override
	public Alumno guardar(AlumnoRequest request) {
		Alumno alumno = new Alumno();
		alumno.setNombre(request.getNombre());
		alumno.setFechaNacimiento(request.getFechaNacimiento());
		alumno.setGenero(request.getGenero());
		alumno.setGrado(request.getGrado());
		alumno.setCiudad(request.getCiudad());
		alumno.setStatus(request.getStatus());

		dao.save(alumno);
		return alumno;
	}

	@Override
	public Alumno editar(AlumnoRequest request) throws NoSePuedeEditarException {
		Alumno alumno = dao.findById(request.getAlumnoID()).get();

		if (alumno.getStatus() == 1) {
			alumno.setNombre(request.getNombre());
			alumno.setFechaNacimiento(request.getFechaNacimiento());
			alumno.setGenero(request.getGenero());
			alumno.setGrado(request.getGrado());
			alumno.setCiudad(request.getCiudad());

			dao.save(alumno);
		} else {
			throw new NoSePuedeEditarException("No se puede editar un alumno dado de baja");
		}

		return alumno;
	}

	@Override
	public Alumno buscar(int id) {

		return dao.findById(id).get();
	}

	@Override
	public String eliminar(int id) {

		dao.deleteById(id);
		return "Registro eliminado";
	}

	@Override
	public List<Alumno> mostrar() {

		return dao.findAll();
	}

	@Override
	public String cambiarStatus(int id) {
		Alumno alumno =  dao.findById(id).get();
		
		alumno.setStatus(0);
		dao.save(alumno);
		return "Alumno dado de baja satisfactoriamente";
	}

}
