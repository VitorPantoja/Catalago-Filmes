package com.lead.catalagofilmes.repository;

import com.lead.catalagofilmes.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    @Query("SELECT u FROM Usuario u WHERE LOWER(u.email) = LOWER(:email) ")
    Optional<Usuario> findByEmail(String email);
}
