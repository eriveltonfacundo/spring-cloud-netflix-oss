package com.cloud.fiscalservice.repositories;

import com.cloud.fiscalservice.entities.SituacaoFiscal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SituacaoFiscalRepository extends JpaRepository<SituacaoFiscal, Long> {
}
