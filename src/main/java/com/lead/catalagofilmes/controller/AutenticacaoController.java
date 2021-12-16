package com.lead.catalagofilmes.controller;


import com.lead.catalagofilmes.controller.dto.TokenDto;
import com.lead.catalagofilmes.models.dto.UsuarioDTO;
import org.springframework.beans.factory.annotation.Autowired;
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
    private TokenServicee tokenService;

    @PostMapping
    public ResponseEntity<TokenDto> autenticacao(@RequestBody @Validated UsuarioDTO usuarioDTO){

        UsernamePasswordAuthenticationToken dadosLogin = usuarioDTO.converter();

        try {
            //chama autenticationService
            Authentication authentication = authenticationManager.authenticate(dadosLogin);


            String token = tokenService.gerarToken(authentication);

            return ResponseEntity.ok(new TokenDto(token, "Bearer"));

        } catch (AuthenticationException e){
            return ResponseEntity.badRequest().build();
        }
    }
}
