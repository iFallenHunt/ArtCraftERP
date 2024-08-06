package com.ArtCraft.service.impl;

import com.ArtCraft.model.ItemVenda;
import com.ArtCraft.repository.ItemVendaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemVendaService {
    private final ItemVendaRepository itemVendaRepository;

    public ItemVendaService(ItemVendaRepository itemVendaRepository) {
        this.itemVendaRepository = itemVendaRepository;
    }

    public List<ItemVenda> findAll() {
        return itemVendaRepository.findAll();
    }

    public ItemVenda save(ItemVenda itemVenda) {
        itemVenda.calcularSubTotal();
        return itemVendaRepository.save(itemVenda);
    }

    public ItemVenda findById(Long id) {
        return itemVendaRepository.findById(id).orElse(null);
    }

    public void deleteById(Long id) {
        itemVendaRepository.deleteById(id);
    }
}