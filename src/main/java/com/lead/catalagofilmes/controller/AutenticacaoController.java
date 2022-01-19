package com.lead.catalagofilmes.controller;
import com.lead.catalagofilmes.security.AuthTokenService;
import com.lead.catalagofilmes.models.dto.TokenDTO;
import com.lead.catalagofilmes.models.dto.UsuarioDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/auth")
public class AutenticacaoController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private AuthTokenService tokenService;

    @PostMapping
    public ResponseEntity<?> autenticacao(@RequestBody @Validated UsuarioDTO usuarioDTO){

        UsernamePasswordAuthenticationToken dadosLogin = usuarioDTO.converter();

        try {
            Authentication authentication = authenticationManager.authenticate(dadosLogin);

            String token = tokenService.gerarToken(authentication);

            //return ResponseEntity.ok(new TokenDTO(token, "Bearer").toString());
            return ResponseEntity.ok(new TokenDTO(token, "Bearer")) ;

        } catch (AuthenticationException e){
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.UNAUTHORIZED);
        }
    }
}
