package com.ArtCraft.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Data
@Schema(description = "Detalhes do Fornecedor")
public class Fornecedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "O ID único do Fornecedor", example = "1")
    private Long id;

    @Schema(description = "O nome do Fornecedor", example = "Fornecedor XYZ")
    private String nome;

    @Column(unique = true)
    @Schema(description = "O CNPJ do Fornecedor", example = "12345678000190")
    private String cnpj;

    @Schema(description = "O telefone do Fornecedor", example = "+55 11 88888-8888")
    private String telefone;

    @Schema(description = "O endereço do Fornecedor", example = "Avenida Paulista, 456")
    private String endereco;
}
