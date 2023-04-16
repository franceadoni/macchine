package com.franceadoni.macchine.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.franceadoni.macchine.models.Marca;
import com.franceadoni.macchine.services.MarcaService;

@RestController
@RequestMapping("/api/marche")
public class MarcaController {
	
	@Autowired
	private MarcaService marcaService;
	
	@GetMapping("")
	@CrossOrigin("*")
	public List<Marca> loadAll() {
		return marcaService.loadAll();		
	}
	
	@PostMapping("")
	@CrossOrigin("*")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Marca add(@RequestBody Marca marca) {
		return marcaService.create(marca);		
	}
	
	@PutMapping("/{id}")
	@CrossOrigin("*")	
	public Marca update(@RequestBody Marca marca, @PathVariable int id) {
		return marcaService.update(marca, id);
	}
	
	@DeleteMapping("/{id}")
	@CrossOrigin("*")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable int id) {
		marcaService.delete(id);
	}
	

}
