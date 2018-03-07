package com.cloud.productservice.services;

import com.cloud.productservice.entities.Secao;
import com.cloud.productservice.repositories.SecaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class SecaoService {

    @Autowired
    private SecaoRepository repository;

    public void save(Secao secao){
        repository.save(secao);
    }

    public void update(Secao secao){
        repository.save(secao);
    }

    public void deleteById(Long produtoId) {
        repository.delete(produtoId);
    }

    public Secao findById(Long secaoId){
        return repository.findOne(secaoId);
    }

    public Page<Secao> findAll(Pageable pageable){
        return repository.findAll(pageable);
    }

    public boolean exists(Long produtoId) {
        return repository.exists(produtoId);
    }
}
