package com.franceadoni.macchine.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.franceadoni.macchine.models.Marca;
import com.franceadoni.macchine.repositories.MarcaRepository;


@Service
public class MarcaService {
	
	@Autowired
	private MarcaRepository marcaRepository;
	
	public List<Marca> loadAll() {
		return marcaRepository.findAll();		
	}
	
	public Marca create(Marca marca) {
		return marcaRepository.save(marca);
	}
	
	public Marca update(Marca newMarca, int id) {
		Marca marca = marcaRepository.findById(id).get();
		marca.setNome(newMarca.getNome());
		marca.setSede(newMarca.getSede());
		return marcaRepository.save(marca);
	}
	
	public void delete(int id) {
		marcaRepository.deleteById(id);
	}

}
