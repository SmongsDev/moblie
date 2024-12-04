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
import kr.or.changwon.changchang.changchang.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/users")
public class UserController {
    
    @Autowired
    private UserService userService;

    @GetMapping("/{userId}/character_status")
    public ResponseEntity<CharacterStatusDTO> getCharacterStatus(@PathVariable Long userId) {
        CharacterStatusDTO characterStatusDTO = userService.getCharacterStatusByUserId(userId);
        
        return ResponseEntity.ok(characterStatusDTO);
    }

    @PostMapping("/create")
    public ResponseEntity<String> createUser(@RequestBody RequestCreateUserDTO requestDto) {
        userService.createUser(requestDto);
        return ResponseEntity.ok("유저 생성");
    }
    


    @GetMapping("/{studentId}/subjects")
    public ResponseEntity<List<SubjectDTO>> getSubjectsWithAssignmentStatus(@PathVariable String studentId) {
        List<SubjectDTO> list = userService.getSubjectsWithAssignmentStatus(studentId);

        return ResponseEntity.ok(list);
    }
}

