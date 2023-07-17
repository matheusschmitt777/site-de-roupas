package com.sitederoupas.roupas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sitederoupas.roupas.entities.Clothes;
import com.sitederoupas.roupas.repositories.ClothesRepository;

@Service
public class ClothesService {

	@Autowired
	private ClothesRepository repository;
	
	public List<Clothes> findAll(){
		return repository.findAll();
	} 

	public Clothes findById(Long id) {
		Optional<Clothes> obj = repository.findById(id);
		return obj.get();
	}
}
