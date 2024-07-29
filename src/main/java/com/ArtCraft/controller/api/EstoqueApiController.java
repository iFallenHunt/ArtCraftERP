package com.ArtCraft.controller.api;

import com.ArtCraft.model.Estoque;
import com.ArtCraft.repository.EstoqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/estoque")
public class EstoqueApiController {

    @Autowired
    private EstoqueRepository estoqueRepository;

    @GetMapping
    public List<Estoque> getAllEstoques() {
        return estoqueRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Estoque> getEstoqueById(@PathVariable Long id) {
        return estoqueRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Estoque createEstoque(@RequestBody Estoque estoque) {
        return estoqueRepository.save(estoque);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Estoque> updateEstoque(@PathVariable Long id, @RequestBody Estoque estoqueDetails) {
        return estoqueRepository.findById(id)
                .map(estoque -> {
                    estoque.setProduto(estoqueDetails.getProduto());
                    estoque.setQuantidade(estoqueDetails.getQuantidade());
                    Estoque updatedEstoque = estoqueRepository.save(estoque);
                    return ResponseEntity.ok(updatedEstoque);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEstoque(@PathVariable Long id) {
        if (!estoqueRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        estoqueRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
