package com.ArtCraft.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
public class Venda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @OneToMany(mappedBy = "venda", cascade = CascadeType.ALL)
    private List<ItemVenda> itens;

    private LocalDate dataVenda;
    private Double valorTotal;

    public void calcularValorTotal() {
        this.valorTotal = itens.stream()
                .mapToDouble(ItemVenda::getSubTotal)
                .sum();
    }
}