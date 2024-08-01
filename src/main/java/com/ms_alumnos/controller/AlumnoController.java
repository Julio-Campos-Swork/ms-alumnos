package com.ms_alumnos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ms_alumnos.entity.Alumno;
import com.ms_alumnos.logic.AlumnoLogic;
import com.ms_alumnos.request.AlumnoRequest;

@RestController
@RequestMapping("alumnos")
public class AlumnoController {

	@Autowired
	AlumnoLogic service;

	@GetMapping("/mostrar")
	public ResponseEntity<List<Alumno>> mostrar() {

		List<Alumno> alumnos = service.mostrar();

//		return ResponseEntity.ok(alumnos);
		return new ResponseEntity<List<Alumno>>(alumnos, HttpStatus.OK);
	}

	@PostMapping("/guardar")
	public ResponseEntity<Alumno> guardar(@RequestBody AlumnoRequest request) {
		Alumno alumno = service.guardar(request);
		return new ResponseEntity<Alumno>(alumno, HttpStatus.OK);
	}

	@PutMapping("/editar")
	public ResponseEntity<Alumno> editar(@RequestBody AlumnoRequest request) {
		Alumno alumno = service.editar(request);
		return new ResponseEntity<Alumno>(alumno, HttpStatus.OK);
	}

	@GetMapping("/buscar/{id}")
	public ResponseEntity<Alumno> buscar(@PathVariable int id) {
		Alumno alumno = service.buscar(id);
		return new ResponseEntity<Alumno>(alumno, HttpStatus.OK);
	}

	@DeleteMapping("/borrar/{id}")
	public ResponseEntity<String> elminar(@PathVariable int id) {
		String result = service.eliminar(id);
		return new ResponseEntity<String>(result, HttpStatus.OK);
	}

	@DeleteMapping("/statusChange/{id}")
	public ResponseEntity<String> statusChange(@PathVariable int id) {
		String result = service.cambiarStatus(id);
		return new ResponseEntity<String>(result, HttpStatus.OK);
	}
}
