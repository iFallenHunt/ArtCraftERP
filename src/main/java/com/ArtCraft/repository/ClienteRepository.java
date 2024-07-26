package com.ArtCraft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ArtCraft.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
