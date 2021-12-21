package com.lead.catalagofilmes.config;

import com.lead.catalagofilmes.config.security.AutenticacaoService;
import com.lead.catalagofilmes.config.security.AutenticacaoTokenFilter;
import com.lead.catalagofilmes.config.security.TokenServicee;
import com.lead.catalagofilmes.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private AutenticacaoService autenticacaoService;

    @Autowired
    private TokenServicee tokenService;

    @Autowired
    private UsuarioService usuarioService;

    @Override
    @Bean
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(autenticacaoService).passwordEncoder(new BCryptPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeRequests()
                .antMatchers(HttpMethod.GET,"/filmes").permitAll()
                .antMatchers(HttpMethod.GET,"/filmes/*").permitAll()
                .antMatchers(HttpMethod.GET,"/categoria").permitAll()
                .antMatchers(HttpMethod.GET,"/categoria/*").permitAll()
                .antMatchers(HttpMethod.GET,"/user/All").permitAll()
                .antMatchers(HttpMethod.POST,"/auth").permitAll()
                .anyRequest().authenticated()
                .and().csrf().disable().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and().addFilterBefore(new AutenticacaoTokenFilter(tokenService, usuarioService), UsernamePasswordAuthenticationFilter.class);

    }

   /*
   @Bean
   public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }*/

    @Override
    public void configure(WebSecurity web) throws Exception {

    }
}
