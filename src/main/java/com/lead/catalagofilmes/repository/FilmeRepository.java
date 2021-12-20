package com.lead.catalagofilmes.repository;

import com.lead.catalagofilmes.models.Categoria;
import com.lead.catalagofilmes.models.Filme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FilmeRepository extends JpaRepository<Filme, Long> {

    @Query("SELECT f FROM Filme f WHERE LOWER(f.titulo) LIKE LOWER(CONCAT('%',:titulo_filme,'%')) ")
    List<Filme> searchName(String titulo_filme);

    List<Filme> findByCategoria(Categoria categoria);
}
