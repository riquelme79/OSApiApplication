
package br.dev.riquelme.OSApiApplication.domain.dto;

import jakarta.validation.constraints.NotBlank;

public record ComentarioDTO(
        
        @NotBlank(message  = "A descricação do comentário não pode estar vazia")
        String descricao) {
}
