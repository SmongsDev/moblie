package kr.or.changwon.changchang.changchang.service;

import kr.or.changwon.changchang.changchang.DTO.requestDTO.RequestCreateUserDTO;
import kr.or.changwon.changchang.changchang.entity.CharacterStatus;
import kr.or.changwon.changchang.changchang.entity.Title;
import kr.or.changwon.changchang.changchang.entity.User;
import kr.or.changwon.changchang.changchang.repository.TitleRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.annotation.Rollback;

import static org.assertj.core.api.Assertions.assertThat;

@EnableAutoConfiguration
@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService; // 서비스 클래스
    private final PasswordEncoder passwordEncoder;
    private final TitleRepository titleRepository;
    
    public UserServiceTest(TitleRepository titleRepository, PasswordEncoder passwordEncoder){
        this.titleRepository = titleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    // @Test
    // @Rollback(false)
    // public void createUserTest() {
    //     String studentId = "20213114";
    //     String username = "윤영필";
    //     String password = "testpassword";
    //     String role = "ROLE_USER";

    //     User user = new User();
    //     user.setStudentId(studentId);
    //     user.setUsername(username);
    //     user.setPassword(passwordEncoder.encode(password));
    //     user.setRole(role);
    
    //     Title defaultTitle = titleRepository.findByName("창대생")
    //         .orElseThrow(() -> new IllegalArgumentException("기본 칭호를 찾을 수 없습니다."));
            
    //     CharacterStatus characterStatus = createDefaultCharacterStatus(defaultTitle);
    //     user.setCharacterStatus(characterStatus);

    //     // 유저가 잘 생성되었는지 확인
    //     assertThat(user).isNotNull();
    //     assertThat(user.getUsername()).isEqualTo(username);
    //     assertThat(user.getPassword()).isNotEqualTo(password); // 암호화된 비밀번호 확인
    //     assertThat(user.getRole()).isEqualTo(role);

    //     // CharacterStatus가 생성되었는지 확인
    //     CharacterStatus testCharacter = user.getCharacterStatus();
    //     assertThat(testCharacter).isNotNull();
    //     assertThat(testCharacter.getGrade()).isEqualTo(1);
    //     assertThat(testCharacter.getStress()).isEqualTo(0);
    //     assertThat(testCharacter.getHappiness()).isEqualTo(100);
    //     assertThat(testCharacter.getFocus()).isEqualTo(50);

    //     // Title이 설정되었는지 확인
    //     assertThat(testCharacter.getTitle()).isNotNull();
    //     assertThat(testCharacter.getTitle().getName()).isEqualTo("창대생");
    // }
    
    // private CharacterStatus createDefaultCharacterStatus(Title defaultTitle) {
    //     CharacterStatus characterStatus = new CharacterStatus();
    //     characterStatus.setGrade(1);
    //     characterStatus.setStress(0);
    //     characterStatus.setHappiness(100);
    //     characterStatus.setFocus(50);
    //     characterStatus.setAcademicAbility(10);
    //     characterStatus.setTitle(defaultTitle);
    //     return characterStatus;
    // }
}
