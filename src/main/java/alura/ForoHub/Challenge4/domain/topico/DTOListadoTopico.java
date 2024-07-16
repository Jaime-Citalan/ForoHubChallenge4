package alura.ForoHub.Challenge4.domain.topico;

public record DTOListadoTopico(Long id, String titulo, String mensaje,
                               String fecha, String estatus,
                               Long autor, String curso) {

    public DTOListadoTopico(Topico topico){
        this(topico.getId(), topico.getTitulo(), topico.getMensaje(), topico.getFecha(),
                topico.getEstatus().toString(), topico.getAutor(), topico.getCurso().toString());
    }
}
