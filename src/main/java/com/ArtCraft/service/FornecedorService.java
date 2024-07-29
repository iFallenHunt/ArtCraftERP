package com.ArtCraft.service;

import com.ArtCraft.model.Fornecedor;
import java.util.List;
import java.util.Optional;

public interface FornecedorService {
    List<Fornecedor> findAll();
    Optional<Fornecedor> findById(Long id);
    Fornecedor insert(Fornecedor fornecedor);
    Fornecedor update(Fornecedor fornecedor);
    void delete(Long id);
    List<Fornecedor> findByName(String name); // Se houver campo 'name' no modelo
}
