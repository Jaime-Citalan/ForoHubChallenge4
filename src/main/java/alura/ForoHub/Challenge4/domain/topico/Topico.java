package alura.ForoHub.Challenge4.domain.topico;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;


@Entity (name = "Topico")
@Table (name = "topicos")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensaje;
    private String fecha;
    @Enumerated(EnumType.STRING)
    private Estatus estatus;
    private Long autor;
    @Enumerated(EnumType.STRING)
    private Curso curso;

    public Topico(DTODatosRegistroTopico datosRegistroTopico){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        this.titulo = datosRegistroTopico.titulo();
        this.mensaje = datosRegistroTopico.mensaje();
        this.fecha = LocalTime.now().format(formatter);
        this.estatus = Estatus.NO_solucionado;
        this.autor = datosRegistroTopico.autor();
        this.curso = datosRegistroTopico.curso();

    }

    public void actualizarDatos(DTOActualizarTopico datosActualizarTopico) {
        if (datosActualizarTopico.titulo() != null){
            this.titulo = datosActualizarTopico.titulo();
        }
        if (datosActualizarTopico.mensaje() != null){
            this.mensaje = datosActualizarTopico.mensaje();
        }
        if (datosActualizarTopico.estatus() != null){
            this.estatus = Estatus.valueOf(datosActualizarTopico.estatus());
        }
        if (datosActualizarTopico.curso() != null){
            this.curso = Curso.valueOf(datosActualizarTopico.curso());
        }


    }

}