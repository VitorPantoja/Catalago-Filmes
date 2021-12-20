package com.lead.catalagofilmes.controller;

import com.lead.catalagofilmes.models.Categoria;
import com.lead.catalagofilmes.models.Idioma;
import com.lead.catalagofilmes.services.IdiomaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@Controller
@RequestMapping(value = "/idiomas")
public class IdiomaController {

    @Autowired
    private IdiomaService idiomaService;

    @ResponseBody
    @GetMapping(value = "/All")
    public ResponseEntity<List<Idioma>> findAll(){
        List<Idioma> list = idiomaService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @ResponseBody
    @GetMapping(value = "/idioma{id}")
    public ResponseEntity<Idioma> findByid(@PathVariable Long id){
        Idioma obj = idiomaService.findById(id);
        return ResponseEntity.ok().body(obj);
    }
    @DeleteMapping(value = "/delete{id}")
    public ResponseEntity<Void> deleteIdioma(@PathVariable Long id){
        idiomaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
    @PostMapping(value = "/create")
    public ResponseEntity<Idioma> salvaCategoria(@RequestBody @Validated Idioma idioma){
        Idioma newIdioma = idiomaService.save(idioma);
        return ResponseEntity.ok().body(newIdioma);
    }

    @PutMapping(value = "/update")
    @Transactional
    public ResponseEntity<Idioma> update(@RequestBody Idioma obj){
        Idioma newIdioma = idiomaService.update(obj);
        return ResponseEntity.ok().body(newIdioma);
    }


}
