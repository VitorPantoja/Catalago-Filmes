package com.lead.catalagofilmes.controller;

import com.lead.catalagofilmes.models.Filme;
import com.lead.catalagofilmes.services.FilmeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(value = "/filmes")
public class FilmeController {

    @Autowired
    private FilmeService filmeService;

    @GetMapping(value = "/filmesAll")
    public ResponseEntity<List<Filme>> findAll(){
        List<Filme> list = filmeService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Filme> findById(@PathVariable Long id){
        Filme obj = filmeService.findById(id);
        return ResponseEntity.ok().body(obj);
    }
}
