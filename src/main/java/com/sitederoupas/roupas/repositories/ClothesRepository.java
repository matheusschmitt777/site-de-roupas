package com.sitederoupas.roupas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sitederoupas.roupas.entities.Clothes;

public interface ClothesRepository extends JpaRepository<Clothes, Long>{

}
