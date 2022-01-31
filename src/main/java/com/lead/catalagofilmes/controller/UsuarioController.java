package com.lead.catalagofilmes.controller;
import com.lead.catalagofilmes.models.Usuario;
import com.lead.catalagofilmes.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value = "/user")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @ResponseBody
    @GetMapping(value = "/All")
    public ResponseEntity<?> findAll(){
        try {
            List<Usuario> usuarios = usuarioService.findAll();
            if (usuarios.isEmpty()){
                return new ResponseEntity<String>("Erro, sem usuários cadastrados",HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<List<Usuario>>(usuarios, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @ResponseBody
    @GetMapping(value = "/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        try {
            Optional<Usuario> obj = usuarioService.findById(id);
            if (!obj.isPresent()){
                return new ResponseEntity<String>("Não foi encontrado o usuário especificado", HttpStatus.NOT_FOUND);
            }
            return ResponseEntity.ok().body(obj);
        }
        catch (Exception e){
            return new ResponseEntity<String>("Usuário não encontrado", HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(value = "/create")
    public ResponseEntity<?> salvaUsuario(@RequestBody @Validated Usuario obj){
        try {
            Usuario salvaUsuario = usuarioService.save(obj);
            return ResponseEntity.ok().body(salvaUsuario);
        }catch (Exception e){
            return new ResponseEntity<String>("Erro ao salvar o usuario",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        try{
            if(!usuarioService.verificaServiceUsuario(id)){
                return new ResponseEntity<String>("Não foi encontrado o usuário especificado",HttpStatus.NOT_FOUND);
            }
            usuarioService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<String>("Erro ao deletar o usuário",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(value = "/update")
    @Transactional
    public ResponseEntity<?>updateUsuario(@RequestBody @Validated Usuario obj){
        try{
            if (!usuarioService.verificaServiceUsuario(obj.getId())){
                return new ResponseEntity<String>("Não foi encontrado o usuário especificado",HttpStatus.NOT_FOUND);
            }
            Usuario atualizaUsuario = usuarioService.update(obj);
            return ResponseEntity.ok().body(atualizaUsuario);
        } catch(Exception e){
            return new ResponseEntity<String>("Erro atualizar em usuário", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
