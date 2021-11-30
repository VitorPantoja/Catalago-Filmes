package com.lead.catalagofilmes.repository;

import com.lead.catalagofilmes.models.Filme;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmeRepository extends JpaRepository<Filme, Long> {
}
