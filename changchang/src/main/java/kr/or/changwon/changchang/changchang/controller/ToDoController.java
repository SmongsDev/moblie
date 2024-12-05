package kr.or.changwon.changchang.changchang.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.or.changwon.changchang.changchang.DTO.TodoDTO;
import kr.or.changwon.changchang.changchang.DTO.requestDTO.RequestTodoDTO;
import kr.or.changwon.changchang.changchang.entity.ToDo;
import kr.or.changwon.changchang.changchang.service.TodoService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/api/todo")
public class ToDoController {

    private final TodoService todoService;

    public ToDoController(TodoService todoService){
        this.todoService = todoService;
    }

    @GetMapping("/{studentId}")
    public ResponseEntity<List<TodoDTO>> getUserTodoList(@PathVariable String studentId) {
        List<TodoDTO> toDo = todoService.getUserTodo(studentId);
        return ResponseEntity.ok(toDo);
    }
    

    @PostMapping("/{studentId}")
    public ResponseEntity<String> addTodoList(@PathVariable String studentId, @RequestBody RequestTodoDTO requestDto){
        todoService.addTodoList(studentId, requestDto);
        return ResponseEntity.ok("Todo 리스트 생성되었습니다.");
    }

    @PutMapping
    public ResponseEntity<String> updateTodo(@RequestBody ToDo todo){
        todoService.updateUserTodo(todo);
        return ResponseEntity.ok("Todo가 업데이트 되었습니다.");
    }
    
    @DeleteMapping("/{todoId}")
    public ResponseEntity<String> deleteTodo(@PathVariable Long todoId){
        todoService.deleteUserTodo(todoId);
        return ResponseEntity.ok("삭제되었습니다.");
    }
    
}
