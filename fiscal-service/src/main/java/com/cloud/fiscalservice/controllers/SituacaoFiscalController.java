package com.cloud.fiscalservice.controllers;

import com.cloud.fiscalservice.entities.SituacaoFiscal;
import com.cloud.fiscalservice.services.SituacaoFiscalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/fiscal-situations")
public class SituacaoFiscalController {

    @Autowired
    private SituacaoFiscalService situacaoFiscalService;

    @GetMapping
    public ResponseEntity<Page<SituacaoFiscal>> findAll(@PageableDefault(page = 0, size = 100) Pageable pageable) {
        Page<SituacaoFiscal> situacoesFiscais = situacaoFiscalService.findAll(pageable);
        if (situacoesFiscais.hasContent())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(situacoesFiscais, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SituacaoFiscal> findById(@PathVariable("id") Long id) {
        SituacaoFiscal situacaoFiscal = situacaoFiscalService.findById(id);
        if (situacaoFiscal == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(situacaoFiscal, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody SituacaoFiscal situacaoFiscal, UriComponentsBuilder uriBuilder) {
        if (situacaoFiscalService.exists(situacaoFiscal.getId()))
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        situacaoFiscalService.save(situacaoFiscal);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(uriBuilder.path("/fiscal-situations/{id}").buildAndExpand(situacaoFiscal.getId()).toUri());
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable("id") Long id, @RequestBody SituacaoFiscal situacaoFiscal) {
        if (!situacaoFiscalService.exists(id))
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        situacaoFiscalService.update(situacaoFiscal);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") Long id) {
        if (!situacaoFiscalService.exists(id))
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        situacaoFiscalService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
