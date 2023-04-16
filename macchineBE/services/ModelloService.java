package com.franceadoni.macchine.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.franceadoni.macchine.models.Modello;
import com.franceadoni.macchine.repositories.ModelloRepository;

@Service
public class ModelloService {
	
	@Autowired
	private ModelloRepository modelloRepository;
	
	public List<Modello> loadAll() {
		return modelloRepository.findAll();		
	}
	
	public Modello create(Modello modello) {
		return modelloRepository.save(modello);		
	}
	
	public Modello update(Modello newModello, int id) {
		Modello modello = modelloRepository.findById(id).get();
		modello.setNome(newModello.getNome());
		modello.setMarca(newModello.getMarca());
		return modelloRepository.save(modello);
	}
	
	public void delete(int id) {
		modelloRepository.deleteById(id);		
	}

}
