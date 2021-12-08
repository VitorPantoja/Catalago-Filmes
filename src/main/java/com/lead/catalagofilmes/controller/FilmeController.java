package com.lead.catalagofilmes.controller;

import com.lead.catalagofilmes.models.Categoria;
import com.lead.catalagofilmes.models.Filme;
import com.lead.catalagofilmes.models.Idioma;
import com.lead.catalagofilmes.services.FilmeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@Controller
@RequestMapping(value = "/filmes")
public class FilmeController {

    @Autowired
    private FilmeService filmeService;

    @ResponseBody
    @GetMapping(value = "/All")
    public ResponseEntity<List<Filme>> findAll(){
        List<Filme> list = filmeService.findAll();
        return ResponseEntity.ok().body(list);
    }
    @ResponseBody
    @GetMapping(value = "/{id}")
    public ResponseEntity<Filme> findById(@PathVariable Long id){
        Filme obj = filmeService.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping(value = "/Cat{id}")
    public ResponseEntity<List<Filme>> findByCategoria(@PathVariable Long id){
        List<Filme> filmes = filmeService.findByCategoria(id);
        return ResponseEntity.ok().body(filmes);
    }

    @PutMapping(value = "/update")
    @Transactional
    public ResponseEntity<Filme> update(@RequestBody Filme obj){
        Filme filme = filmeService.update(obj);
        return ResponseEntity.ok().body(filme);
    }

    @DeleteMapping(value = "/delete{id}")
    public ResponseEntity<Void> deleteFilme(@PathVariable Long id){
        filmeService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/findByname{filme}")
    public ResponseEntity<List<Filme>> findById(@PathVariable String filme){
        List<Filme> list = filmeService.searchName(filme);
        return ResponseEntity.ok().body(list);
    }

    @PostMapping(value = "/create")
    public ResponseEntity<Filme> salvaFilme(@RequestBody Filme filme){
        Filme newFilme = filmeService.save(filme);
        return ResponseEntity.ok().body(newFilme);
    }
}
