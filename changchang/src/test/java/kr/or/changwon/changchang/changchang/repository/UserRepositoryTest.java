package kr.or.changwon.changchang.changchang.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import kr.or.changwon.changchang.changchang.entity.User;
import kr.or.changwon.changchang.changchang.service.UserService;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Test
    public void setUp() {
        // User user = User.builder()
        //     .username("testuser")
        //     .password(passwordEncoder.encode("testpassword"))
        //     .role("ROLE_USER")
        //     .build();
        // userRepository.save(user);
        
        userService.createUser("testuser", passwordEncoder.encode("testpassword"), "ROLE_USER");
        
    }

    @Test
    public void testUserExists() {
        User user = userRepository.findByUsername("testuser").orElse(null);
        assertThat(user).isNotNull();
        assertThat(passwordEncoder.matches("testpassword", user.getPassword())).isTrue();
        assertThat(user.getRole()).isEqualTo("ROLE_USER");
    }
}
