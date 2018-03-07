package com.cloud.productservice.services;

import com.cloud.productservice.entities.Produto;
import com.cloud.productservice.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    public void save(Produto produto) {
        repository.save(produto);
    }

    public void update(Produto produto) {
        repository.save(produto);
    }

    public void deleteById(Long produtoId) {
        repository.delete(produtoId);
    }

    public Produto findById(Long produtoId) {
        return repository.findOne(produtoId);
    }

    public Page<Produto> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public boolean exists(Long produtoId) {
        return repository.exists(produtoId);
    }

}
