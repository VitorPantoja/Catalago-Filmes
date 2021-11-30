package com.lead.catalagofilmes.controller;

import com.lead.catalagofilmes.models.Idioma;
import com.lead.catalagofilmes.services.IdiomaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(value = "/idiomas")
public class IdiomaController {

    @Autowired
    private IdiomaService idiomaService;

    @GetMapping(value = "/idiomasAll")
    public ResponseEntity<List<Idioma>> findAll(){
        List<Idioma> list = idiomaService.findAll();
        return ResponseEntity.ok().body(list);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<Idioma> findByid(@PathVariable Long id){
        Idioma obj = idiomaService.findById(id);
        return ResponseEntity.ok().body(obj);
    }
}
