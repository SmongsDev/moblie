package kr.or.changwon.changchang.changchang.controller;

import kr.or.changwon.changchang.changchang.DTO.CharacterTitleDTO;
import kr.or.changwon.changchang.changchang.DTO.requestDTO.RequestStatusDTO;
import kr.or.changwon.changchang.changchang.service.CharacterStatusService;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/api/character")
public class CharacterStatusController {

    private final CharacterStatusService characterStatusService;

    public CharacterStatusController(CharacterStatusService characterStatusService) {
        this.characterStatusService = characterStatusService;
    }

    @PostMapping("/{studentId}")
    public ResponseEntity<String> updateCharacterStatus(@PathVariable String studentId, @RequestBody RequestStatusDTO requestDto) {
        characterStatusService.updateCharacterStatus(studentId, requestDto);
        return ResponseEntity.ok("상태가 변경되었습니다.");
    }

    // 캐릭터가 소유한 Title 리스트 가져오기
    @GetMapping("/{studentId}/titles")
    public ResponseEntity<List<CharacterTitleDTO>> getCharacterTitles(@PathVariable String studentId) {
        List<CharacterTitleDTO> titles = characterStatusService.getCharacterTitles(studentId);
        return ResponseEntity.ok(titles);
    }
    
    // 캐릭터에 Title 추가 (소유 처리)
    @PostMapping("/{studentId}/title/{titleId}")
    public ResponseEntity<String> addTitleToCharacter(@PathVariable String studentId, @PathVariable Long titleId) {
        characterStatusService.addTitleToCharacter(studentId, titleId);
        return ResponseEntity.ok("Title added to character.");
    }

    // 현재 사용 중인 Title 변경
    @PutMapping("/{studentId}/title/{titleId}")
    public ResponseEntity<String> changeCurrentTitle(@PathVariable String studentId, @PathVariable Long titleId) {
        characterStatusService.changeCurrentTitle(studentId, titleId);
        return ResponseEntity.ok("Current Title updated.");
    }
}

