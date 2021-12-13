package com.lead.catalagofilmes.services;

import com.lead.catalagofilmes.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String emailUser) throws UsernameNotFoundException {

        if (emailUser != null){
            usuarioRepository.findByEmail(emailUser);
        }

        throw new UsernameNotFoundException("Usuário com email: "+ emailUser+" não encontrado");
    }
}
