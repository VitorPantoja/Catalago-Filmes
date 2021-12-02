package com.lead.catalagofilmes.controller;

import com.lead.catalagofilmes.models.Usuario;
import com.lead.catalagofilmes.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(value = "/user")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @ResponseBody
    @GetMapping(value = "/userAll")
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
}
