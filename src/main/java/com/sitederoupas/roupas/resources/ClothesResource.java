package com.sitederoupas.roupas.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sitederoupas.roupas.entities.Clothes;
import com.sitederoupas.roupas.services.ClothesService;

@RestController
@RequestMapping(value = "/clothes")
public class ClothesResource {

	@Autowired
	private ClothesService service;
	
	@GetMapping
	public ResponseEntity<List<Clothes>> findAll(){
		List<Clothes> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Clothes> findById(@PathVariable Long id) {
		Clothes obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
