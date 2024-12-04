package kr.or.changwon.changchang.changchang.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.or.changwon.changchang.changchang.DTO.CharacterStatusDTO;
import kr.or.changwon.changchang.changchang.DTO.ResponseDTO.ResponseSubjectDTO;
import kr.or.changwon.changchang.changchang.DTO.requestDTO.RequestCreateUserDTO;
import kr.or.changwon.changchang.changchang.entity.Subject;
import kr.or.changwon.changchang.changchang.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/user")
public class UserController {
    
    @Autowired
    private UserService userService;

    @GetMapping("/{studentId}/character")
    public ResponseEntity<CharacterStatusDTO> getCharacterStatus(@PathVariable String studentId) {
        CharacterStatusDTO characterStatusDTO = userService.getCharacterStatusByUserId(studentId);
        
        return ResponseEntity.ok(characterStatusDTO);
    }

    // 유저 생성
    @PostMapping("/create")
    public ResponseEntity<String> createUser(@RequestBody RequestCreateUserDTO requestDto) {
        userService.createUser(requestDto);
        return ResponseEntity.ok("유저 생성");
    }

    // 사용자가 수강 중인 과목 조회
    @GetMapping("/{userId}/subjects")
    public ResponseEntity<List<ResponseSubjectDTO>> getSubjects(@PathVariable Long userId) {
        List<ResponseSubjectDTO> subjects = userService.getSubjectsByUserId(userId);
        return ResponseEntity.ok(subjects);
    }

    // 사용자가 새로운 과목 등록
    @PostMapping("/{userId}/subjects/{subjectId}")
    public ResponseEntity<String> enrollSubject(@PathVariable Long userId, @PathVariable Long subjectId) {
        userService.addUserSubject(userId, subjectId);
        return ResponseEntity.ok("과목 추가 완료");
    }
    
}