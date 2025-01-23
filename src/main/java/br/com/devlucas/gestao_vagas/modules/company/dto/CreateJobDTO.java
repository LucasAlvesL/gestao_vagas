package br.com.devlucas.gestao_vagas.modules.company.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class CreateJobDTO {

    @Schema(example = "Java Developer")
    private String description;
    @Schema(example = "Remote")
    private String benefits;
    @Schema(example = "Junior")
    private String level;

}
