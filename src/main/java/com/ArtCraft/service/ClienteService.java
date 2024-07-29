package com.ArtCraft.service;

import com.ArtCraft.model.Cliente;
import java.util.List;
import java.util.Optional;

public interface ClienteService {
    List<Cliente> findAll();
    Optional<Cliente> findById(Long id);
    Cliente insert(Cliente cliente);
    Cliente update(Cliente cliente);
    void delete(Long id);
    List<Cliente> findByName(String name);
}
