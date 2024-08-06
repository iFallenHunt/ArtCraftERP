package com.ArtCraft.model;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
public class ItemVenda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "produto_id")
    private Produto produto;

    @ManyToOne
    @JoinColumn(name = "venda_id")
    private Venda venda;

    private Integer quantidade;
    private Double subTotal;

    public void calcularSubTotal() {
        this.subTotal = produto.getPreco() * quantidade;
    }
}