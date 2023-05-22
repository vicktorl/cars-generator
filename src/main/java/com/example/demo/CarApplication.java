package com.example.demo;


import models.automovil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class CarApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarApplication.class, args);
	}

	@RestController
	public class automovilController {

		@GetMapping("/automoviles/{cantidad}")
		public List<automovil> generarautomoviles(@PathVariable int cantidad) {
			List<automovil> automoviles = new ArrayList<>();
			for (int i = 0; i < cantidad; i++) {
				automovil automovil = new automovil();
				automoviles.add(automovil);
			}
			return automoviles;
		}
	}

}
