package com.backendtest.ecommercezara.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.backendtest.ecommercezara.models.DateSet;
import com.backendtest.ecommercezara.repositories.DateSetRepository;

@Service
public class DateSetServiceImpl implements BaseService<DateSet> {

    @Autowired
    private DateSetRepository dateRepository;

    @Override
    @Transactional
    public List<DateSet> findAll() {
        return dateRepository.findAll();
    }

    @Override
    @Transactional
    public Page<DateSet> findAll(Pageable pageable) {
        return dateRepository.findAll(pageable);
    }

    @Override
    @Transactional
    public Optional<DateSet> findById(Long id) {
        return dateRepository.findById(id);
    }

    @Override
    @Transactional
    public DateSet save(DateSet dateproduct) {
        return dateRepository.save(dateproduct);
    }

    @Override
    public void deleteById(Long id) {
        dateRepository.deleteById(id);
    }

}
