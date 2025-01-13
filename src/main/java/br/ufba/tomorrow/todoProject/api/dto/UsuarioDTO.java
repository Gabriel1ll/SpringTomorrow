package br.ufba.tomorrow.todoProject.api.dto;

import br.ufba.tomorrow.todoProject.domain.entities.Usuario;

public class UsuarioDTO {
    Long id;
    String email;

    public UsuarioDTO() {}
    public UsuarioDTO(Usuario usu) {
        this.id = usu.getId();
        this.email = usu.getEmail();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
