package com.cloud.fiscalservice.services;

import com.cloud.fiscalservice.entities.SituacaoFiscal;
import com.cloud.fiscalservice.repositories.SituacaoFiscalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class SituacaoFiscalService {

    @Autowired
    private SituacaoFiscalRepository repository;

    public void save(SituacaoFiscal situacaoFiscal) {
        repository.save(situacaoFiscal);
    }

    public void update(SituacaoFiscal situacaoFiscal) {
        repository.save(situacaoFiscal);
    }

    public void deleteById(Long situacaoFiscalId) {
        repository.delete(situacaoFiscalId);
    }

    public SituacaoFiscal findById(Long situacaoFiscalId) {
        return repository.findOne(situacaoFiscalId);
    }

    public Page<SituacaoFiscal> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public boolean exists(Long situacaoFiscalId) {
        return repository.exists(situacaoFiscalId);
    }
}
