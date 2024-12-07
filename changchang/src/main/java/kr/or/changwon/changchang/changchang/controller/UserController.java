package kr.or.changwon.changchang.changchang.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.or.changwon.changchang.changchang.DTO.CharacterStatusDTO;
import kr.or.changwon.changchang.changchang.DTO.SubjectDTO;
import kr.or.changwon.changchang.changchang.DTO.requestDTO.RequestCreateUserDTO;
import kr.or.changwon.changchang.changchang.DTO.requestDTO.RequestPointsDTO;
import kr.or.changwon.changchang.changchang.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/user")
public class UserController {
    
    @Autowired
    private UserService userService;

    @GetMapping("/{studentId}")
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
    @GetMapping("/{studentId}/subjects")
    public ResponseEntity<List<SubjectDTO>> getSubjects(@PathVariable String studentId) {
        List<SubjectDTO> subjects = userService.getSubjectsByUserId(studentId);
        return ResponseEntity.ok(subjects);
    }

    // 사용자가 새로운 과목 등록
    @PostMapping("/{studentId}/subjects/{subjectId}")
    public ResponseEntity<String> enrollSubject(@PathVariable String studentId, @PathVariable Long subjectId) {
        userService.addUserSubject(studentId, subjectId);
        return ResponseEntity.ok("과목 추가 완료");
    }

    // 사용자의 포인터 변경
    @PostMapping("/{studentId}/points")
    public ResponseEntity<String> updateUserpoints(@PathVariable String studentId, @RequestBody RequestPointsDTO requestDto){
        return ResponseEntity.ok("현재 사용자의 포인터는 " + userService.updatePoints(studentId, requestDto));
    }
    
    @GetMapping("/{studentId}/points")
    public ResponseEntity<Long> getMethodName(@PathVariable String studentId) {
        Long point = userService.getPoints(studentId);
        return ResponseEntity.ok(point);
    }
    
}