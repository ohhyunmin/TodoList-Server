package org.example.controller;

import lombok.AllArgsConstructor;
import org.example.model.TodoListEntity;
import org.example.model.TodoListRequest;
import org.example.model.TodoListResponse;
import org.example.service.TodoListService;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin
@AllArgsConstructor
@RequestMapping("/")
public class TodoListController {
    private final TodoListService service;

    @PostMapping
    public ResponseEntity<TodoListResponse> create(@RequestBody TodoListRequest request){
        System.out.println("create");
        if(ObjectUtils.isEmpty(request.getTitle()))
            return ResponseEntity.badRequest().build();
        if(ObjectUtils.isEmpty(request.getOrder()))
            request.setOrder(0L);
        if(ObjectUtils.isEmpty(request.getCompleted()))
            request.setCompleted(false);

        TodoListEntity todoListEntity = this.service.add(request);
        return ResponseEntity.ok(new TodoListResponse(todoListEntity));
    }

    @GetMapping("{id}")
    public ResponseEntity<TodoListResponse> readOne(@PathVariable Long id){
        System.out.println("readOne");
        TodoListEntity todoListEntity = this.service.searchById(id);
        return ResponseEntity.ok(new TodoListResponse(todoListEntity));
    }

    @GetMapping
    public ResponseEntity<List<TodoListResponse>> readAll(){
        System.out.println("readAll");
        List<TodoListEntity> todoListEntities = this.service.searchAll();
        List<TodoListResponse> todoListResponses = todoListEntities.stream().map(TodoListResponse::new).collect(Collectors.toList());
        return ResponseEntity.ok(todoListResponses);
    }

    @PatchMapping("{id}")
    public ResponseEntity<TodoListResponse> update(@PathVariable Long id, @RequestBody TodoListRequest request){
        System.out.println("update");
        TodoListEntity todoListEntity = this.service.updateById(id, request);
        return ResponseEntity.ok(new TodoListResponse(todoListEntity));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteOne(@PathVariable Long id){
        System.out.println("deleteOne");
        this.service.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping
    public ResponseEntity<?> deleteAll(){
        System.out.println("deleteAll");
        this.service.deleteAll();
        return ResponseEntity.ok().build();
    }
}
