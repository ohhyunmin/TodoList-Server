package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TodoListResponse {
    private Long id;
    private String title;
    private Long order;
    private Boolean completed;
    private String url;

    public TodoListResponse(TodoListEntity todoListEntity){
        this.id = todoListEntity.getId();
        this.title = todoListEntity.getTitle();
        this.order = todoListEntity.getOrder();
        this.completed = todoListEntity.getCompleted();
        this.url = "http://localhost:8080/" + this.id;
    }
}
