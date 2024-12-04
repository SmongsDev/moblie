package kr.or.changwon.changchang.changchang.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import kr.or.changwon.changchang.changchang.DTO.CharacterStatusDTO;
import kr.or.changwon.changchang.changchang.DTO.SubjectDTO;
import kr.or.changwon.changchang.changchang.DTO.requestDTO.RequestCreateUserDTO;
import kr.or.changwon.changchang.changchang.entity.AssignmentStatus;
import kr.or.changwon.changchang.changchang.entity.CharacterStatus;
import kr.or.changwon.changchang.changchang.entity.Title;
import kr.or.changwon.changchang.changchang.entity.User;
import kr.or.changwon.changchang.changchang.repository.TitleRepository;
import kr.or.changwon.changchang.changchang.repository.UserRepository;

@Service
public class UserService implements UserDetailsService {

    private final TitleRepository titleRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(TitleRepository titleRepository, UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.titleRepository = titleRepository;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public CharacterStatusDTO getCharacterStatusByUserId(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        
        CharacterStatus characterStatus = user.getCharacterStatus();

        return new CharacterStatusDTO(user, characterStatus);
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), 
                List.of(new SimpleGrantedAuthority(user.getRole())));
    }
    @Transactional
    public User createUser(RequestCreateUserDTO requestDto) {
        User user = new User();
        user.setUsername(requestDto.getUsername());
        user.setPassword(passwordEncoder.encode(requestDto.getPassword()));
        user.setRole("ROLE_USER");
    
        Title defaultTitle = titleRepository.findByName("창대생")
            .orElseThrow(() -> new IllegalArgumentException("기본 칭호를 찾을 수 없습니다."));
            
        CharacterStatus characterStatus = createDefaultCharacterStatus(defaultTitle);
        user.setCharacterStatus(characterStatus);
    
        return userRepository.save(user);
    }
    
    private CharacterStatus createDefaultCharacterStatus(Title defaultTitle) {
        CharacterStatus characterStatus = new CharacterStatus();
        characterStatus.setGrade(1);
        characterStatus.setIntel(10);
        characterStatus.setHealth(100);
        characterStatus.setStress(0);
        characterStatus.setHappiness(50);
        characterStatus.setFocus(10);
        characterStatus.setTimeManagement(10);
        characterStatus.setLeadership(10);
        characterStatus.setCreativity(10);
        characterStatus.setSocialSkills(10);
        characterStatus.setAcademicAbility(10);
        characterStatus.setTitle(defaultTitle);
        return characterStatus;
    }

    @Transactional
    public List<SubjectDTO> getSubjectsWithAssignmentStatus(Long userId) {
        User user = userRepository.findById(userId)
            .orElseThrow(() -> new RuntimeException("User not found"));

        return user.getAssignmentStatuses().stream()
            .map(status -> new SubjectDTO(status.getSubject(), status.isSubmitted()))
            .collect(Collectors.toList());
    }
}

