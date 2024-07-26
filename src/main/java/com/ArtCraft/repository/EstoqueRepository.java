package com.ArtCraft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ArtCraft.erp.model.Estoque;

public interface EstoqueRepository extends JpaRepository<Estoque, Long> {
}
