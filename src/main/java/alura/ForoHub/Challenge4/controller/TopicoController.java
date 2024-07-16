package alura.ForoHub.Challenge4.controller;

import alura.ForoHub.Challenge4.domain.topico.DTODatosRegistroTopico;
import alura.ForoHub.Challenge4.domain.topico.DTORespuestaTopico;
import alura.ForoHub.Challenge4.domain.topico.ITopicoRepositorio;
import alura.ForoHub.Challenge4.domain.topico.Topico;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/topicos")
public class TopicoController {
    @Autowired
    private ITopicoRepositorio iTopicoRepositorio;

    @PostMapping
    public ResponseEntity<DTORespuestaTopico> registrarTopico
            (@RequestBody @Valid DTODatosRegistroTopico datosRegistroTopico,
             UriComponentsBuilder uriComponentsBuilder) {
        Topico topico = iTopicoRepositorio.save(new Topico(datosRegistroTopico));

        DTORespuestaTopico datosRespuestaTopico = new DTORespuestaTopico(topico);
        URI url = uriComponentsBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
        return ResponseEntity.created(url).body(datosRespuestaTopico);
    }
}
