package kr.or.changwon.changchang.changchang.controller;

import kr.or.changwon.changchang.changchang.DTO.requestDTO.RequestStatusDTO;
import kr.or.changwon.changchang.changchang.service.CharacterStatusService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/character")
public class CharacterStatusController {

    private final CharacterStatusService characterStatusService;

    public CharacterStatusController(CharacterStatusService characterStatusService) {
        this.characterStatusService = characterStatusService;
    }

    @PostMapping("/{studentId}/title/{titleId}")
    public ResponseEntity<String> equipTitle(@PathVariable String studentId, @PathVariable Long titleId) {
        characterStatusService.equipTitle(studentId, titleId);
        return ResponseEntity.ok("칭호가 변경되었습니다.");
    }

    @PostMapping("/{studentId}/status")
    public ResponseEntity<String> updateCharacterStatus(@PathVariable String studentId, @RequestBody RequestStatusDTO requestDto) {
        
        return ResponseEntity.ok("상태가 변경되었습니다.");
    }
    
}

