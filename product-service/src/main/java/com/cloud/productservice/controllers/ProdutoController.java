package com.cloud.productservice.controllers;


import com.cloud.productservice.entities.Produto;
import com.cloud.productservice.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;

@RestController
@RequestMapping("/products")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public ResponseEntity<Page<Produto>> findAll(@PageableDefault(page = 0, size = 100) Pageable pageable) {
        Page<Produto> produtos = produtoService.findAll(pageable);
        if (produtos.hasContent())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(produtos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> findById(@PathVariable("id") Long id) {
        Produto produto = produtoService.findById(id);
        if (produto == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(produto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody @Valid Produto produto, UriComponentsBuilder uriBuilder) {
        if (produtoService.exists(produto.getId()))
            return new ResponseEntity<>(HttpStatus.CONFLICT);

        produtoService.save(produto);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(uriBuilder.path("/products/{id}").buildAndExpand(produto.getId()).toUri());
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable("id") Long id, @RequestBody @Valid Produto produto) {
        if (!produtoService.exists(id))
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        produtoService.update(produto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") Long id) {
        if (produtoService.exists(id))
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        produtoService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
