package com.backendtest.ecommercezara.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.backendtest.ecommercezara.models.Price;
import com.backendtest.ecommercezara.repositories.PriceRepository;

@Service
public class PriceServiceImpl implements BaseService<Price> {

    @Autowired
    private PriceRepository productRepository;

    @Override
    @Transactional
    public List<Price> findAll() {
        return productRepository.findAll();
    }

    @Override
    @Transactional
    public Page<Price> findAll(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    @Override
    @Transactional
    public Optional<Price> findById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    @Transactional
    public Price save(Price product) {
        return productRepository.save(product);
    }

    @Override
    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }


}
