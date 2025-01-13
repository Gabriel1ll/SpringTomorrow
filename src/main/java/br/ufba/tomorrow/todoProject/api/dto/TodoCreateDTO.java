package br.ufba.tomorrow.todoProject.api.dto;

import br.ufba.tomorrow.todoProject.domain.entities.Estado;

import java.time.LocalDate;

public class TodoCreateDTO {
    long idUsu;
    String item;
    LocalDate prazo;
    Estado estado;

    public long getIdUsu() {
        return idUsu;
    }

    public void setIdUsu(long idUsu) {
        this.idUsu = idUsu;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public LocalDate getPrazo() {
        return prazo;
    }

    public void setPrazo(LocalDate prazo) {
        this.prazo = prazo;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
}
