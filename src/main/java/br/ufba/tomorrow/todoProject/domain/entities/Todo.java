package br.ufba.tomorrow.todoProject.domain.entities;

import br.ufba.tomorrow.todoProject.api.dto.TodoCreateDTO;
import br.ufba.tomorrow.todoProject.api.dto.TodoUpdateDTO;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name="tb_todos")
public class Todo{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name="id_usuario")
    private Usuario usuario;
    private String item;
    private LocalDate prazo;
    private Estado estado;
    private LocalDate conclusao;

    public Todo() {}

    public Todo(TodoCreateDTO todo) {
        setUsuario(new Usuario(todo.getIdUsu()));
        setEstado(todo.getEstado());
        setItem(todo.getItem());
        setPrazo(todo.getPrazo());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public String getItem() {

        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
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

    public LocalDate getConclusao() {
        return conclusao;
    }

    public void setConclusao(LocalDate conclusao) {
        this.conclusao = conclusao;
    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Todo todo = (Todo) o;
        return Objects.equals(id, todo.id) && Objects.equals(usuario, todo.usuario) && Objects.equals(item, todo.item) && Objects.equals(prazo, todo.prazo) && Objects.equals(estado, todo.estado) && Objects.equals(conclusao, todo.conclusao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, usuario, item, prazo, estado, conclusao);
    }

    public Todo(TodoUpdateDTO dto){
        this.item = dto.getItem();
        this.prazo = dto.getPrazo();
        this.estado = dto.getEstado();
        this.conclusao = dto.getConclusao();
        this.id = dto.getId();
    }
}
