package kr.or.changwon.changchang.changchang.service;

import kr.or.changwon.changchang.changchang.DTO.requestDTO.RequestCreateUserDTO;
import kr.or.changwon.changchang.changchang.entity.CharacterStatus;
import kr.or.changwon.changchang.changchang.entity.Title;
import kr.or.changwon.changchang.changchang.entity.User;
import kr.or.changwon.changchang.changchang.repository.TitleRepository;
import kr.or.changwon.changchang.changchang.repository.UserRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.annotation.Rollback;

@EnableAutoConfiguration
@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TitleRepository titleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserService userService;

    @Test
    @Rollback(false)
    public void voidcreateUserTest() {
        String studentId = "20213115";
        String username = "이관호";
        String password = "testpassword";
        String role = "ROLE_USER";
        
        RequestCreateUserDTO requestDto = new RequestCreateUserDTO();
        requestDto.setStudentId(studentId);
        requestDto.setUsername(username);
        requestDto.setPassword(password);

        userService.createUser(requestDto);
    }
}
