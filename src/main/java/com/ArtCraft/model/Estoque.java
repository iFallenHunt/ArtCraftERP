package com.ArtCraft.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
@Schema(description = "Detalhes do Estoque")
public class Estoque {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "O ID único do Estoque", example = "1")
    private Long id;

    @Schema(description = "O nome do produto no Estoque", example = "Produto A")
    private String produto;

    @Schema(description = "A quantidade do produto no Estoque", example = "100")
    private Integer quantidade;
}
