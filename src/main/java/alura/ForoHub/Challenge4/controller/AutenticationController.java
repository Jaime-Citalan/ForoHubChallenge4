package alura.ForoHub.Challenge4.controller;

import alura.ForoHub.Challenge4.domain.usuario.AutenticationUsuarios;
import alura.ForoHub.Challenge4.domain.usuario.Usuario;
import alura.ForoHub.Challenge4.seguridad.security.DatosToken;
import alura.ForoHub.Challenge4.seguridad.security.Token;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/login")
public class AutenticationController{

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private Token token;

    @PostMapping
    public ResponseEntity autenticarUsuario(@RequestBody @Valid AutenticationUsuarios datosAutenticacionUsuario){
        Authentication authToken = new UsernamePasswordAuthenticationToken
                (datosAutenticacionUsuario.login(), datosAutenticacionUsuario.contrasena());
        var usuarioAutenticado = authenticationManager.authenticate(authToken);
        var JWTtoken = token.generarToken((Usuario) usuarioAutenticado.getPrincipal());
        return ResponseEntity.ok(new DatosToken(JWTtoken));
    }
}
