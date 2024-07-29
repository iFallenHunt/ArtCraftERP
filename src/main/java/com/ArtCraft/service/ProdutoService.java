package com.ArtCraft.service;

import com.ArtCraft.model.Produto;
import java.util.List;
import java.util.Optional;

public interface ProdutoService {
    List<Produto> findAll();
    Optional<Produto> findById(Long id);
    Produto insert(Produto produto);
    Produto update(Produto produto);
    void delete(Long id);
    List<Produto> findByName(String name); // Se houver campo 'name' no modelo
}
