package com.ArtCraft.service.impl;

import com.ArtCraft.model.Estoque;
import com.ArtCraft.repository.EstoqueRepository;
import com.ArtCraft.service.EstoqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstoqueServiceImpl implements EstoqueService {

    @Autowired
    private EstoqueRepository estoqueRepository;

    @Override
    public List<Estoque> findAll() {
        return estoqueRepository.findAll();
    }

    @Override
    public Optional<Estoque> findById(Long id) {
        return estoqueRepository.findById(id);
    }

    @Override
    public Estoque insert(Estoque estoque) {
        return estoqueRepository.save(estoque);
    }

    @Override
    public Estoque update(Estoque estoque) {
        if (estoqueRepository.existsById(estoque.getId())) {
            return estoqueRepository.save(estoque);
        }
        throw new IllegalArgumentException("Estoque not found");
    }

    @Override
    public void delete(Long id) {
        estoqueRepository.deleteById(id);
    }

    @Override
    public List<Estoque> findByName(String name) {
        // Implementar método de busca por nome se necessário
        return estoqueRepository.findByProdutoContainingIgnoreCase(name);
    }
}
