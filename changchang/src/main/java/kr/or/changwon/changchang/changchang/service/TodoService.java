package kr.or.changwon.changchang.changchang.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import kr.or.changwon.changchang.changchang.DTO.TodoDTO;
import kr.or.changwon.changchang.changchang.DTO.requestDTO.RequestTodoDTO;
import kr.or.changwon.changchang.changchang.entity.ToDo;
import kr.or.changwon.changchang.changchang.entity.User;
import kr.or.changwon.changchang.changchang.repository.TodoRepository;
import kr.or.changwon.changchang.changchang.repository.UserRepository;

@Service
public class TodoService {
    
    private final UserRepository userRepository;
    private final TodoRepository todoRepository;

    public TodoService(UserRepository userRepository, TodoRepository todoRepository){
        this.userRepository = userRepository;
        this.todoRepository = todoRepository;
    }

    @Transactional
    public void addTodoList(String studentId, RequestTodoDTO requestDto){
        User user = userRepository.findByStudentId(studentId)
            .orElseThrow(() -> new IllegalArgumentException("User not found"));

        ToDo todo = new ToDo();
        todo.setUser(user);
        todo.setContent(requestDto.getContent());
        todoRepository.save(todo);
    }

    @Transactional
    public List<TodoDTO> getUserTodo(String studentId){
        User user = userRepository.findByStudentId(studentId)
            .orElseThrow(() -> new IllegalArgumentException("User not found"));
        
        List<TodoDTO> res = todoRepository.findByUserId(user.getId())
                .stream()
                .map(todo -> {
                    TodoDTO dto = new TodoDTO();
                    dto.setId(todo.getId());
                    dto.setContent(todo.getContent());
                    dto.setStudentId(studentId);
                    return dto;
                })
                .collect(Collectors.toList());
        return res;
    }

    @Transactional
    public void updateUserTodo(ToDo requestTodo){
        ToDo todo = todoRepository.findById(requestTodo.getId())
            .orElseThrow(() -> new IllegalArgumentException("Todo not found"));

        todo.setContent(requestTodo.getContent());
        todoRepository.save(todo);
    }

    @Transactional
    public void deleteUserTodo(Long todoId){
        todoRepository.deleteById(todoId);
    }
}
