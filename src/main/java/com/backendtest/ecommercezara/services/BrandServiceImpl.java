package com.backendtest.ecommercezara.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.backendtest.ecommercezara.models.Brand;
import com.backendtest.ecommercezara.repositories.BrandRepository;

@Service
public class BrandServiceImpl implements BaseService<Brand> {

    @Autowired
    private BrandRepository brandRepository;

    @Override
    @Transactional
    public List<Brand> findAll() {
        return brandRepository.findAll();
    }

    @Override
    @Transactional
    public Page<Brand> findAll(Pageable pageable) {
        return brandRepository.findAll(pageable);
    }

    @Override
    @Transactional
    public Optional<Brand> findById(Long id) {
        return brandRepository.findById(id);
    }

    @Override
    @Transactional
    public Brand save(Brand brand) {
        return brandRepository.save(brand);
    }

    @Override
    public void deleteById(Long id) {
        brandRepository.deleteById(id);
    }

}
