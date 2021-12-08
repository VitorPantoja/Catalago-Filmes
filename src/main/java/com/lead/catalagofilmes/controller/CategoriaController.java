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
    @GetMapping (value = "/All")
    public ResponseEntity<List<Categoria>> findAll(){
        List<Categoria> list = categoriaService.findAll();
        return ResponseEntity.ok().body(list);
    }
    @ResponseBody
    @GetMapping(value = "/id{id}")
    public ResponseEntity<Categoria> findById(@PathVariable Long id){
        Categoria obj = categoriaService.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PutMapping(value = "/categoriaUP")
    @Transactional
    public ResponseEntity<Categoria> updateCategoria(@RequestBody Categoria obj){
        Categoria categoria = categoriaService.update(obj);
        return ResponseEntity.ok().body(categoria);
    }

    @DeleteMapping(value = "/categoriaDel/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        categoriaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

   /* @DeleteMapping(value = "/delete{id}")
    public ResponseEntity<String> deleteCategoria(@PathVariable Long id){
        categoriaService.deleteById(id);
        return ResponseEntity.ok().body("Deletado com sucesso !");

    }*/


    @PostMapping(value = "/create")
    public ResponseEntity<Categoria> salvaCategoria(@RequestBody Categoria categoria){
        Categoria newCategoria = categoriaService.save(categoria);
        return ResponseEntity.ok().body(newCategoria);
    }

}
