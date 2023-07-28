package com.sitederoupas.roupas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sitederoupas.roupas.entities.Clothes;
import com.sitederoupas.roupas.repositories.ClothesRepository;
import com.sitederoupas.roupas.services.exceptions.DatabaseException;
import com.sitederoupas.roupas.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ClothesService {

	@Autowired
	private ClothesRepository repository;
	
	@Transactional
	public List<Clothes> findAll(){
		return repository.findAll();
	} 

	@Transactional
	public Clothes findById(Long id) {
		Optional<Clothes> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	@Transactional
	public Clothes insert(Clothes obj) {
		return repository.save(obj);
	}
	
	@Transactional
	public void delete(Long id) {
		try {
	        if (repository.existsById(id)) {
	            repository.deleteById(id);			
	        } else {				
	            throw new ResourceNotFoundException(id);			
	        }		
	    } catch (DataIntegrityViolationException e) {			
	        throw new DatabaseException(e.getMessage());		
	    }
	}
	
	@Transactional
	public Clothes update(Long id, Clothes obj) {
		try {
			Clothes entity = repository.getReferenceById(id);
			updateData(entity, obj);
			return repository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	@Transactional
	public void updateData(Clothes entity, Clothes obj) {
		entity.setGarmentName(obj.getGarmentName());
		entity.setDescription(obj.getDescription());
		entity.setPrice(obj.getPrice());
		entity.setImgUrl(obj.getImgUrl());
	}
}
