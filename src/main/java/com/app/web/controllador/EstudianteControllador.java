package com.app.web.controllador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.app.web.servicio.EstudianteServicio;

@Controller
public class EstudianteControllador {
	
	@Autowired EstudianteServicio servicio;
	
	@GetMapping({"/estudiantes", "/"})
	private String listarEstudiantes(Model model) {
		
		model.addAttribute("estudiantes", servicio.listarTodosLosEstudiantes());
		return "estudiantes";
	}

}
