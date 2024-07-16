package alura.ForoHub.Challenge4.domain.usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface IUsuarioRepositorio extends JpaRepository<Usuario, Long> {
    UserDetails findByLogin(String username);
}
