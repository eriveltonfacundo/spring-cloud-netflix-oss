package com.cloud.productservice.controllers;


import com.cloud.productservice.entities.Secao;
import com.cloud.productservice.services.SecaoService;
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
@RequestMapping("/sections")
public class SecaoController {

    @Autowired
    private SecaoService secaoService;

    @GetMapping
    public ResponseEntity<Page<Secao>> findAll(@PageableDefault(page = 0, size = 100) Pageable pageable) {
        Page<Secao> secoes = secaoService.findAll(pageable);
        if (secoes.hasContent())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(secoes, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Secao> findById(@PathVariable("id") Long id) {
        Secao secoes = secaoService.findById(id);
        if (secoes == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(secoes, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody Secao secao, UriComponentsBuilder uriBuilder) {
        if (secaoService.exists(secao.getId()))
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        secaoService.save(secao);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(uriBuilder.path("/sections/{id}").buildAndExpand(secao.getId()).toUri());
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable("id") Long id, @RequestBody Secao user) {
        if (!secaoService.exists(id))
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        secaoService.update(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") Long id) {
        if (!secaoService.exists(id))
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        secaoService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
