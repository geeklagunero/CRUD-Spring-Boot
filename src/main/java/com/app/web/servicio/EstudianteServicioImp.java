package com.app.web.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.web.entidad.Estudiante;
import com.app.web.repositorio.EstudianteRepositorio;

@Service
public class EstudianteServicioImp implements EstudianteServicio {
	
	@Autowired 
	private EstudianteRepositorio repositorio;

	@Override
	public List<Estudiante> listarTodosLosEstudiantes() {
		
		return repositorio.findAll();
	}

	@Override
	public Estudiante guardarEstudiante(Estudiante estudiante) {
		return repositorio.save(estudiante);
	}

	@Override
	public Estudiante obtenerEstudiantePorId(long id) {
		return repositorio.findById(id).get();
	}

	@Override
	public Estudiante actulizarEstudiante(Estudiante estudiante) {
		return repositorio.save(estudiante);
	}

	@Override
	public void eliminarEstudiante(long id) {
		repositorio.deleteById(id);
	}

}
