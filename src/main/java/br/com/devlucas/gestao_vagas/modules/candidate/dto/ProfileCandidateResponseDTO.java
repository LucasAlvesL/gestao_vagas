package br.com.devlucas.gestao_vagas.modules.candidate.dto;

import java.util.UUID;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProfileCandidateResponseDTO {

    @Schema(example = "Java Developer")
    private String description;

    @Schema(example = "devlucas")
    private String username;

    @Schema(example = "email@gmail.com")
    private String email;
    private UUID id;

    @Schema(example = "Lucas")
    private String name;
}
