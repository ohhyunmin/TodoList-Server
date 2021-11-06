package org.example.service;

import lombok.AllArgsConstructor;
import org.example.model.TodoListEntity;
import org.example.model.TodoListRequest;
import org.example.repository.TodoListRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@AllArgsConstructor
public class TodoListService {
    private final TodoListRepository todoListRepository;

    public TodoListEntity add(TodoListRequest request){
        TodoListEntity todoListEntity = new TodoListEntity();
        todoListEntity.setTitle(request.getTitle());
        todoListEntity.setOrder(request.getOrder());
        todoListEntity.setCompleted(request.getCompleted());
        return this.todoListRepository.save(todoListEntity);
    }

    public TodoListEntity searchById(Long id){
        return this.todoListRepository.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public List<TodoListEntity> searchAll(){
        return this.todoListRepository.findAll();
    }

    public TodoListEntity updateById(Long id, TodoListRequest request){
        TodoListEntity todoListEntity = this.searchById(id);
        if(request.getTitle()!=null){
            todoListEntity.setTitle(request.getTitle());
        }
        if(request.getOrder() !=null){
            todoListEntity.setOrder(request.getOrder());
        }
        if(request.getCompleted() !=null){
            todoListEntity.setCompleted(request.getCompleted());
        }
        return this.todoListRepository.save(todoListEntity);
    }

    public void deleteById(Long id){
        this.todoListRepository.deleteById(id);
    }

    public void deleteAll(){
        this.todoListRepository.deleteAll();
    }
}
