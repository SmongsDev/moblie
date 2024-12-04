package kr.or.changwon.changchang.changchang.service;

import kr.or.changwon.changchang.changchang.DTO.requestDTO.RequestCreateUserDTO;
import kr.or.changwon.changchang.changchang.entity.CharacterStatus;
import kr.or.changwon.changchang.changchang.entity.Title;
import kr.or.changwon.changchang.changchang.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.mysql.cj.result.RowList;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService; // 서비스 클래스

    @Test
    @Rollback(false)
    public void createUserTest() {
        // 유저 생성
        Long id = (long) 20213114;
        String username = "윤영필";
        String password = "testpassword";
        String role = "ROLE_USER";

        RequestCreateUserDTO requestDto = new RequestCreateUserDTO(id, username, password);

        User createdUser = userService.createUser(requestDto);

        // 유저가 잘 생성되었는지 확인
        assertThat(createdUser).isNotNull();
        assertThat(createdUser.getUsername()).isEqualTo(username);
        assertThat(createdUser.getPassword()).isNotEqualTo(password); // 암호화된 비밀번호 확인
        assertThat(createdUser.getRole()).isEqualTo(role);

        // CharacterStatus가 생성되었는지 확인
        CharacterStatus characterStatus = createdUser.getCharacterStatus();
        assertThat(characterStatus).isNotNull();
        assertThat(characterStatus.getGrade()).isEqualTo(1);
        assertThat(characterStatus.getHealth()).isEqualTo(100);
        assertThat(characterStatus.getIntel()).isEqualTo(10);
        assertThat(characterStatus.getStress()).isEqualTo(0);

        // Title이 설정되었는지 확인
        assertThat(characterStatus.getTitle()).isNotNull();
        assertThat(characterStatus.getTitle().getName()).isEqualTo("창대생");
    }
}
