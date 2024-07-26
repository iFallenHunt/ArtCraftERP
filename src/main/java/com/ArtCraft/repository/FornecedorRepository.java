package com.ArtCraft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ArtCraft.model.Fornecedor;

public interface FornecedorRepository extends JpaRepository<Fornecedor, Long> {
}
