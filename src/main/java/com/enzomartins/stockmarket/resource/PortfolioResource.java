package com.enzomartins.stockmarket.resource;

import java.util.List;

import com.enzomartins.stockmarket.entities.Portfolio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

import com.enzomartins.stockmarket.service.PortfolioService;


@RestController
@RequestMapping(value = "/portfolios")
public class PortfolioResource {

	@Autowired
    private PortfolioService service;

    @GetMapping
    public ResponseEntity<List<Portfolio>> findAll() {
        List<Portfolio> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Portfolio> findById(@PathVariable Long id) {
        Portfolio obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<Portfolio> insert(@RequestBody Portfolio obj) {
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(obj.getId())
                .toUri();

        return ResponseEntity.created(uri).body(obj);
    }
}
