package kr.or.changwon.changchang.changchang.service;

import kr.or.changwon.changchang.changchang.DTO.requestDTO.RequestAssignmentDTO;
import kr.or.changwon.changchang.changchang.DTO.requestDTO.RequestCreateUserDTO;
import kr.or.changwon.changchang.changchang.DTO.requestDTO.RequestTodoDTO;
import kr.or.changwon.changchang.changchang.entity.User;
import kr.or.changwon.changchang.changchang.repository.TodoRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

@EnableAutoConfiguration
@SpringBootTest
public class UserServiceTest {
    @Autowired
    private UserService userService;

    @Autowired
    private TodoService todoService;

    @Autowired
    private AssignmentStatusService assignmentStatusService;

    private String studentId = "20213115";
    private String username = "윤영필";
    private String password = "testpassword";
    private String content = "또 영필이야?";

    @Test
    @Rollback(false)
    public void voidcreateUserTest() {
        
        RequestCreateUserDTO requestDto = new RequestCreateUserDTO();
        requestDto.setStudentId(studentId);
        requestDto.setUsername(username);
        requestDto.setPassword(password);

        userService.createUser(requestDto);
    }
    
    @Test
    public void createUserTodo(){
        RequestTodoDTO requestDto = new RequestTodoDTO();
        requestDto.setContent(content);

        todoService.addTodoList(studentId, requestDto);
    }

    @Test
    public void createUserSubject(){

        userService.addUserSubject(studentId, (long) 1);
        userService.addUserSubject(studentId, (long) 2);
        userService.addUserSubject(studentId, (long) 3);

        RequestAssignmentDTO requestDto = new RequestAssignmentDTO();
        requestDto.setStudentId(studentId);
        requestDto.setSubjectName("고급자료구조");
        requestDto.setDeadline("2024/12/7");

        assignmentStatusService.addAssignment(requestDto);
        
        RequestAssignmentDTO requestDto1 = new RequestAssignmentDTO();
        requestDto1.setStudentId(studentId);
        requestDto1.setSubjectName("모바일프로그래밍");
        requestDto1.setDeadline("2024/12/24");

        assignmentStatusService.addAssignment(requestDto1);
    }
}
