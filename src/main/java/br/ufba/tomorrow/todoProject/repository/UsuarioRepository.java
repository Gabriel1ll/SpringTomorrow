package br.ufba.tomorrow.todoProject.repository;

import br.ufba.tomorrow.todoProject.domain.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    public Usuario save(Usuario usuario);

    Usuario findByEmail(String email);
}
