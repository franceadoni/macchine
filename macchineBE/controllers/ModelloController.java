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

import com.franceadoni.macchine.models.Modello;
import com.franceadoni.macchine.services.ModelloService;

@RestController
@RequestMapping("/api/modelli")
public class ModelloController {
	
	@Autowired
	public ModelloService modelloService;
	
	@GetMapping("")
	@CrossOrigin("*")
	public List<Modello> listAll() {
		return modelloService.loadAll();
	}
	
	@PostMapping("")
	@CrossOrigin("*")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Modello create(@RequestBody Modello modello) {
		return modelloService.create(modello);
	}
	
	@PutMapping("/{id}")
	@CrossOrigin("*")
	public Modello update(@RequestBody Modello modello, @PathVariable int id) {
		return modelloService.update(modello, id);
	}
	
	@DeleteMapping("/{id}")
	@CrossOrigin("*")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable int id) {
		modelloService.delete(id);
	}

}
