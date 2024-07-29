package com.ArtCraft.service.impl;

import com.ArtCraft.model.Produto;
import com.ArtCraft.repository.ProdutoRepository;
import com.ArtCraft.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoServiceImpl implements ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Override
    public List<Produto> findAll() {
        return produtoRepository.findAll();
    }

    @Override
    public Optional<Produto> findById(Long id) {
        return produtoRepository.findById(id);
    }

    @Override
    public Produto insert(Produto produto) {
        return produtoRepository.save(produto);
    }

    @Override
    public Produto update(Produto produto) {
        if (produtoRepository.existsById(produto.getId())) {
            return produtoRepository.save(produto);
        }
        throw new IllegalArgumentException("Produto not found");
    }

    @Override
    public void delete(Long id) {
        produtoRepository.deleteById(id);
    }

    @Override
    public List<Produto> findByName(String name) {
        // Implementar método de busca por nome se necessário
        return produtoRepository.findByNomeContainingIgnoreCase(name);
    }
}
