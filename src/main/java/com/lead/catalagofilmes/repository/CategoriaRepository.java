package com.lead.catalagofilmes.repository;

import com.lead.catalagofilmes.models.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
