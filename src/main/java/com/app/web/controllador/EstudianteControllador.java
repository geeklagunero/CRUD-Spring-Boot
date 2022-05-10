package com.app.web.controllador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.app.web.entidad.Estudiante;
import com.app.web.servicio.EstudianteServicio;

@Controller
public class EstudianteControllador {
	
	@Autowired EstudianteServicio servicio;
	
	@GetMapping({"/estudiantes", "/"})
	private String listarEstudiantes(Model model) {
		
		model.addAttribute("estudiantes", servicio.listarTodosLosEstudiantes());
		return "estudiantes";
	}
	
	
	@GetMapping("/estudiantes/nuevo")
	public String formularioCrearEstudiante(Model model) {
		Estudiante estudiante = new Estudiante();
		model.addAttribute("estudiante", estudiante);
		return "crear_estudiante";
	}
	
	@PostMapping("/estudiantes")
	public String guardarEstudiante(@ModelAttribute("estudiante") Estudiante estudiante) {
		servicio.guardarEstudiante(estudiante);
		return "redirect:estudiantes";
	}
	
	@GetMapping("/estudiantes/editar/{id}")
	public String mostrarFormularioEditar(@PathVariable Long id, Model modelo) {
		modelo.addAttribute("estudiante", servicio.obtenerEstudiantePorId(id));
		
		return "editar_estudiante";
		
	}
	
	@PostMapping("/estudiantes/{id}")
	public String actulizarEstudiante(@PathVariable Long id, @ModelAttribute("estudiante") Estudiante estudiante, Model modelo) {
		Estudiante estudianteActulizar = servicio.obtenerEstudiantePorId(id);
		estudianteActulizar.setId(id);
		estudianteActulizar.setNombre(estudiante.getNombre()); //estudiante.getNombre es lo que viene del formulario actualizado
		estudianteActulizar.setApellido(estudiante.getApellido());
		estudianteActulizar.setEmail(estudiante.getEmail());
		
		servicio.actulizarEstudiante(estudianteActulizar);
		
		return "redirect:/estudiantes";
	}
	
	@GetMapping("/estudiantes/{id}")
	public String eliminarEstudiante(@PathVariable Long id) {
		servicio.eliminarEstudiante(id);
		return "redirect:/estudiantes";
	}

}
