package alura.ForoHub.Challenge4.domain.topico;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


public record DTODatosRegistroTopico(
        @NotNull
        Long autor,
        @NotBlank
        String titulo,
        @NotBlank
        String mensaje,
        @NotNull
        Curso curso) {
}
