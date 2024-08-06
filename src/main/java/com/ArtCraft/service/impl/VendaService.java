package com.ArtCraft.service.impl;

import com.ArtCraft.model.Venda;
import com.ArtCraft.repository.VendaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VendaService {
    private final VendaRepository vendaRepository;

    public VendaService(VendaRepository vendaRepository) {
        this.vendaRepository = vendaRepository;
    }

    public List<Venda> findAll() {
        return vendaRepository.findAll();
    }

    public Venda save(Venda venda) {
        venda.calcularValorTotal();
        return vendaRepository.save(venda);
    }

    public Venda findById(Long id) {
        return vendaRepository.findById(id).orElse(null);
    }

    public void deleteById(Long id) {
        vendaRepository.deleteById(id);
    }
}