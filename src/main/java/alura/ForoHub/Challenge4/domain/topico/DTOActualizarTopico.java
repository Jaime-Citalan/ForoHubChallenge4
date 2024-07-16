package alura.ForoHub.Challenge4.domain.topico;

import jakarta.validation.constraints.NotNull;

public record DTOActualizarTopico(@NotNull Long id, String titulo, String mensaje,
                                  String estatus, String curso) {
}
