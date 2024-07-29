package com.ArtCraft.repository;

import com.ArtCraft.model.Estoque;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EstoqueRepository extends JpaRepository<Estoque, Long> {
    List<Estoque> findByProdutoContainingIgnoreCase(String produto);
}
