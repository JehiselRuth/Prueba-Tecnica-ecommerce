package com.backendtest.ecommercezara.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backendtest.ecommercezara.models.Price;

public interface PriceRepository extends JpaRepository <Price, Long>{
    
}
