package com.sitederoupas.roupas.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.sitederoupas.roupas.entities.Clothes;
import com.sitederoupas.roupas.repositories.ClothesRepository;

@Configuration
public class ClothesConfig implements CommandLineRunner{

	@Autowired
	private ClothesRepository clothesRepository;

	@Override
	public void run(String... args) throws Exception {
		Clothes c1 = new Clothes(null, "Camisa", "Oversized", 60.99, "");
		Clothes c2 = new Clothes(null, "Calça", "Cargo", 100.99, "");
		
		clothesRepository.saveAll(Arrays.asList(c1,c2));
		
	}

}
