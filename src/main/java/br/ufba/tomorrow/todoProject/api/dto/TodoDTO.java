package br.ufba.tomorrow.todoProject.api.dto;

import br.ufba.tomorrow.todoProject.domain.entities.Estado;
import br.ufba.tomorrow.todoProject.domain.entities.Todo;

import java.time.LocalDate;

public class TodoDTO {
    long id;
    String item;
    LocalDate prazo;
    Estado estado;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
    public TodoDTO() {}

    public TodoDTO(Todo todo) {
        this.id = todo.getId();
        this.item = todo.getItem();
        this.prazo = todo.getPrazo();
        this.estado = todo.getEstado();
    }

}
