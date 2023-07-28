package com.sitederoupas.roupas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	
	public Clothes insert(Clothes obj) {
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	@Transactional
	public Clothes update(Long id, Clothes obj) {
		Clothes entity = repository.getReferenceById(id);
		updateData(entity, obj);
		return repository.save(entity);
	}

	public void updateData(Clothes entity, Clothes obj) {
		entity.setGarmentName(obj.getGarmentName());
		entity.setDescription(obj.getDescription());
		entity.setPrice(obj.getPrice());
		entity.setImgUrl(obj.getImgUrl());
	}
}
