package br.ufba.tomorrow.todoProject.domain.services;

import br.ufba.tomorrow.todoProject.api.dto.TodoCreateDTO;
import br.ufba.tomorrow.todoProject.api.dto.TodoDTO;
import br.ufba.tomorrow.todoProject.api.dto.TodoUpdateDTO;
import br.ufba.tomorrow.todoProject.domain.entities.Estado;
import br.ufba.tomorrow.todoProject.domain.entities.Todo;
import br.ufba.tomorrow.todoProject.domain.entities.Usuario;
import br.ufba.tomorrow.todoProject.repository.TodoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TodoService {
    private final TodoRepository repository;
    public TodoService(final TodoRepository repository){
        this.repository = repository;
    }

    public TodoDTO criar(TodoCreateDTO todo){
        return new TodoDTO(repository.save(new Todo(todo)));
    }

    public List<TodoDTO> listarTodosdeUmUsuario(long userId){
        return repository.findByUsuario(new Usuario(userId))
                .stream()
                .map(TodoDTO::new)
                .collect(Collectors.toList());
    }
    public List<TodoDTO> listarTodosDeUmUsuarioComEstado(long userId, Estado estado){
        return repository.findByUsuarioAndEstado(new Usuario(userId), estado)
                .stream()
                .map(TodoDTO::new)
                .collect(Collectors.toList());
    }

    public TodoDTO alterar(TodoUpdateDTO dto) throws Exception {
        Todo existe = (Todo) repository.findById(dto.getId());
        if(existe != null){
            Todo inserir = new Todo(dto);
            inserir.setUsuario(existe.getUsuario());
            return new TodoDTO(repository.save(inserir));
        }
        else throw new Exception("Objeto não encontrado com id: " + dto.getId());
    }
    }

