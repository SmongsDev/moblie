package kr.or.changwon.changchang.changchang.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import kr.or.changwon.changchang.changchang.entity.CharacterStatus;
import kr.or.changwon.changchang.changchang.entity.User;
import kr.or.changwon.changchang.changchang.repository.UserRepository;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), 
                List.of(new SimpleGrantedAuthority(user.getRole())));
    }

    @Transactional
    public User createUser(String username, String rawPassword, String role) {
        User user = User.builder()
            .username(username)
            .password(passwordEncoder.encode(rawPassword))
            .role(role)
            .build();

        CharacterStatus characterStatus = new CharacterStatus();
        characterStatus.setGrade(1);
        characterStatus.setIntel(10);
        characterStatus.setHealth(100);
        characterStatus.setStress(0);
        characterStatus.setTitle("학생");

        user.setCharacterStatus(characterStatus);
        return userRepository.save(user);
    }
}

