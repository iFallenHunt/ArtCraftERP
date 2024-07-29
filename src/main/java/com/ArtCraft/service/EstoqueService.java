package com.ArtCraft.service;

import com.ArtCraft.model.Estoque;
import java.util.List;
import java.util.Optional;

public interface EstoqueService {
    List<Estoque> findAll();
    Optional<Estoque> findById(Long id);
    Estoque insert(Estoque estoque);
    Estoque update(Estoque estoque);
    void delete(Long id);
    List<Estoque> findByName(String name); // Se houver campo 'name' no modelo
}
