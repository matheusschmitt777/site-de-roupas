package com.sitederoupas.roupas.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.sitederoupas.roupas.entities.Clothes;
import com.sitederoupas.roupas.services.ClothesService;

@RestController
@RequestMapping(value = "/clothes")
@CrossOrigin(origins = "*")
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
	
	@PostMapping
	public ResponseEntity<Clothes> insert(@RequestBody Clothes obj) {
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Clothes> update(@PathVariable Long id, @RequestBody Clothes obj) {
		obj = service.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}
}
