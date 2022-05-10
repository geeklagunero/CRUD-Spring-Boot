package com.app.web;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//import com.app.web.entidad.Estudiante;
//import com.app.web.repositorio.EstudianteRepositorio;

@SpringBootApplication
public class CrudSpringApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(CrudSpringApplication.class, args);
	}
	
	//@Autowired
	//private EstudianteRepositorio repositorio;

	@Override
	public void run(String... args) throws Exception {
		/*
		Estudiante estu1 = new Estudiante("lenin", "Roman", "lenin@gmail.com");
		repositorio.save(estu1);
		Estudiante estu2 = new Estudiante("Emanuel", "Roman", "emanuel@gmail.com");
		repositorio.save(estu2);
		Estudiante estu3 = new Estudiante("Diego", "Roman", "diego@gmail.com");
		repositorio.save(estu3);*/
		
	}

}
