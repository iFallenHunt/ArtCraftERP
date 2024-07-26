package com.ArtCraft.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

@Entity
@Data
@Schema(description = "Detalhes do Cliente")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "O ID único do Cliente", example = "1")
    private Long id;

    @Schema(description = "O nome do Cliente", example = "João da Silva")
    private String nome;

    @Schema(description = "O e-mail do Cliente", example = "joao.silva@example.com")
    private String email;

    @Schema(description = "O telefone do Cliente", example = "+55 11 99999-9999")
    private String telefone;

    @Schema(description = "O endereço do Cliente", example = "Rua das Flores, 123")
    private String endereco;

    @Schema(description = "A data de aniversário do Cliente", example = "01/01/1990")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataNascimento;
}
