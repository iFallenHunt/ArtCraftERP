package com.ArtCraft.service.impl;

import com.ArtCraft.model.Fornecedor;
import com.ArtCraft.repository.FornecedorRepository;
import com.ArtCraft.service.FornecedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FornecedorServiceImpl implements FornecedorService {

    @Autowired
    private FornecedorRepository fornecedorRepository;

    @Override
    public List<Fornecedor> findAll() {
        return fornecedorRepository.findAll();
    }

    @Override
    public Optional<Fornecedor> findById(Long id) {
        return fornecedorRepository.findById(id);
    }

    @Override
    public Fornecedor insert(Fornecedor fornecedor) {
        return fornecedorRepository.save(fornecedor);
    }

    @Override
    public Fornecedor update(Fornecedor fornecedor) {
        if (fornecedorRepository.existsById(fornecedor.getId())) {
            return fornecedorRepository.save(fornecedor);
        }
        throw new IllegalArgumentException("Fornecedor not found");
    }

    @Override
    public void delete(Long id) {
        fornecedorRepository.deleteById(id);
    }

    @Override
    public List<Fornecedor> findByName(String name) {
        // Implementar método de busca por nome se necessário
        return fornecedorRepository.findByNomeContainingIgnoreCase(name);
    }
}
