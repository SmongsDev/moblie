package kr.or.changwon.changchang.changchang.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.or.changwon.changchang.changchang.entity.CharacterStatus;
import kr.or.changwon.changchang.changchang.repository.CharacterStatusRepository;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private CharacterStatusRepository characterStatusRepository;

    @GetMapping("/character/{userId}")
    public ResponseEntity<CharacterStatus> getCharacterStatus(@PathVariable Long userId) {
        return characterStatusRepository.findById(userId)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }
}
