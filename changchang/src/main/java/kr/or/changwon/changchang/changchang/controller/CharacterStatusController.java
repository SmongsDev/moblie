package kr.or.changwon.changchang.changchang.controller;

import kr.or.changwon.changchang.changchang.service.CharacterStatusService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/character_status")
public class CharacterStatusController {

    private final CharacterStatusService characterStatusService;

    public CharacterStatusController(CharacterStatusService characterStatusService) {
        this.characterStatusService = characterStatusService;
    }

    @PutMapping("/{userId}/title/{titleId}")
    public String equipTitle(@PathVariable Long userId, @PathVariable Long titleId) {
        characterStatusService.equipTitle(userId, titleId);
        return "칭호가 변경되었습니다.";
    }
}

