package com.lead.catalagofilmes.repository;

import com.lead.catalagofilmes.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}