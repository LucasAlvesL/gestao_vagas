package br.com.devlucas.gestao_vagas.modules.candidate.entity;

import java.time.LocalDateTime;
import java.util.UUID;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
@Entity(name = "candidate")
public class CandidateEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Schema(description = "Candidate Full Name", example = "Lucas", required = true)
    private String name;

    @NotBlank
    @Schema(description = "Candidate Username", example = "devlucas", required = true)
    @Pattern(regexp = "\\S+", message = "O campo [username] não deve conter espaços")
    private String username;

    @Email(message = "O campo [email] deve conter um email válido")
    @Schema(description = "Candidate Email", example = "email@gmail", required = true)
    private String email;

    @Length(min = 5, max = 100, message = "A senha deve conter entre 5 e 100 caracteres")
    @Schema(description = "Candidate Password", example = "123456", minLength = 5, maxLength = 100, required = true)
    private String password;

    @Schema(example = "Java Developer")
    private String description;

    private String curriculum;

    @CreationTimestamp
    private LocalDateTime createdAt;

}
