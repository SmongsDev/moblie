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
import kr.or.changwon.changchang.changchang.DTO.ResponseDTO.ResponseSubjectDTO;
import kr.or.changwon.changchang.changchang.DTO.requestDTO.RequestCreateUserDTO;
import kr.or.changwon.changchang.changchang.entity.CharacterStatus;
import kr.or.changwon.changchang.changchang.entity.Subject;
import kr.or.changwon.changchang.changchang.entity.Title;
import kr.or.changwon.changchang.changchang.entity.User;
import kr.or.changwon.changchang.changchang.repository.SubjectRepository;
import kr.or.changwon.changchang.changchang.repository.TitleRepository;
import kr.or.changwon.changchang.changchang.repository.UserRepository;

@Service
public class UserService implements UserDetailsService {

    private final TitleRepository titleRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final SubjectRepository subjectRepository;

    public UserService(TitleRepository titleRepository, UserRepository userRepository, PasswordEncoder passwordEncoder, SubjectRepository subjectRepository) {
        this.titleRepository = titleRepository;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.subjectRepository = subjectRepository;
    }

    @Transactional
    public CharacterStatusDTO getCharacterStatusByUserId(String studentId) {
        User user = userRepository.findByStudentId(studentId)
            .orElseThrow(() -> new RuntimeException("User not found"));
        
        CharacterStatus characterStatus = user.getCharacterStatus();

        return new CharacterStatusDTO(user, characterStatus);
    }


    @Override
    public UserDetails loadUserByUsername(String studentId) throws UsernameNotFoundException {
        User user = userRepository.findByStudentId(studentId)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), 
                List.of(new SimpleGrantedAuthority(user.getRole())));
    }

    @Transactional
    public User createUser(RequestCreateUserDTO requestDto) {
        User user = new User();
        user.setStudentId(requestDto.getStudentId());
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
        characterStatus.setStress(0);
        characterStatus.setHappiness(100);
        characterStatus.setFocus(50);
        characterStatus.setAcademicAbility(10);
        characterStatus.setTitle(defaultTitle);
        return characterStatus;
    }

    // 사용자가 수강 중인 과목 조회
    public List<ResponseSubjectDTO> getSubjectsByUserId(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        List<ResponseSubjectDTO> responseDto = user.getSubjects().stream()
                .map(subject -> new ResponseSubjectDTO(subject))
                .collect(Collectors.toList());

        return responseDto;
    }

    // 사용자가 새로운 과목 수강 등록
    public void addUserSubject(Long userId, Long subjectId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        Subject subject = subjectRepository.findById(subjectId)
                .orElseThrow(() -> new RuntimeException("Subject not found"));

        user.getSubjects().add(subject);
        userRepository.save(user);
    }
}

