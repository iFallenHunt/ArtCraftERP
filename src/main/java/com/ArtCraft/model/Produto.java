package com.ArtCraft.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
@Schema(description = "Detalhes do Produto")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "O ID único do Produto", example = "1")
    private Long id;

    @Schema(description = "O nome do Produto", example = "Produto A")
    private String nome;

    @Schema(description = "A descrição do Produto", example = "Descrição detalhada do Produto A")
    private String descricao;

    @Schema(description = "O preço do Produto", example = "19.99")
    private Double preco;

    @Schema(description = "A quantidade do Produto em estoque", example = "100")
    private Integer quantidade;
}
