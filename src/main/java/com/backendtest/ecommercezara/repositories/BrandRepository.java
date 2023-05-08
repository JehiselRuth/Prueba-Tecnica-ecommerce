package com.backendtest.ecommercezara.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backendtest.ecommercezara.models.Brand;

public interface BrandRepository extends JpaRepository <Brand, Long>{
    
}
