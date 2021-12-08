package com.lead.catalagofilmes.controller;

import com.lead.catalagofilmes.models.Categoria;
import com.lead.catalagofilmes.models.Usuario;
import com.lead.catalagofilmes.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@Controller
@RequestMapping(value = "/user")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @ResponseBody
    @GetMapping(value = "/All")
    public ResponseEntity<List<Usuario>> findAll(){
        List<Usuario> list = usuarioService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @ResponseBody
    @GetMapping(value = "/{id}")
    public ResponseEntity<Usuario> findById(@PathVariable Long id){
        Usuario obj = usuarioService.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping(value = "/create")
    public ResponseEntity<Usuario> salvaCategoria(@RequestBody Usuario obj){
        Usuario newUsuario = usuarioService.save(obj);
        return ResponseEntity.ok().body(newUsuario);
    }

    @DeleteMapping(value = "/delete{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        usuarioService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/update")
    @Transactional
    public ResponseEntity<Usuario> updateCategoria(@RequestBody Usuario obj){
        Usuario newUsuario = usuarioService.update(obj);
        return ResponseEntity.ok().body(newUsuario);
    }
}
