package alura.ForoHub.Challenge4.seguridad.security;

import alura.ForoHub.Challenge4.domain.usuario.IUsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AutenticacionServicios implements UserDetailsService {
    @Autowired
    private IUsuarioRepositorio iUsuarioRepositorio;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return iUsuarioRepositorio.findByLogin(username);
    }
}



