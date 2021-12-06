package com.lead.catalagofilmes.controller;

import com.lead.catalagofilmes.models.Categoria;
import com.lead.catalagofilmes.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;


@Controller
@RequestMapping(value = "/categoria")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @ResponseBody
    @GetMapping (value = "/categoriaAll")
    public ResponseEntity<List<Categoria>> findAll(){
        List<Categoria> list = categoriaService.findAll();
        return ResponseEntity.ok().body(list);
    }
    @ResponseBody
    @GetMapping(value = "/categoriaid{id}")
    public ResponseEntity<Categoria> findById(@PathVariable Long id){
        Categoria obj = categoriaService.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PutMapping(value = "/categoria{id}")
    @Transactional
    public ResponseEntity<Categoria> update(@RequestBody Categoria obj){
        obj = categoriaService.update(obj);
        return ResponseEntity.ok().body(obj);
    }
}
