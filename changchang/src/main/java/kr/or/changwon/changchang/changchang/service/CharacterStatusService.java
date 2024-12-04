package kr.or.changwon.changchang.changchang.service;

import jakarta.transaction.Transactional;
import kr.or.changwon.changchang.changchang.DTO.requestDTO.RequestStatusDTO;
import kr.or.changwon.changchang.changchang.entity.CharacterStatus;
import kr.or.changwon.changchang.changchang.entity.Title;
import kr.or.changwon.changchang.changchang.entity.User;
import kr.or.changwon.changchang.changchang.repository.CharacterStatusRepository;
import kr.or.changwon.changchang.changchang.repository.TitleRepository;
import kr.or.changwon.changchang.changchang.repository.UserRepository;

import org.springframework.stereotype.Service;

@Service
public class CharacterStatusService {

    private final UserRepository userRepository;
    private final CharacterStatusRepository characterStatusRepository;
    private final TitleRepository titleRepository;

    public CharacterStatusService(UserRepository userRepository, CharacterStatusRepository characterStatusRepository, TitleRepository titleRepository){
        this.titleRepository = titleRepository;
        this.characterStatusRepository = characterStatusRepository;
        this.userRepository = userRepository;
    }

    @Transactional
    public void equipTitle(String studentId, Long titleId) {
        User user = userRepository.findByStudentId(studentId)
            .orElseThrow(() -> new IllegalArgumentException("User not found"));

        Title title = titleRepository.findById(titleId)
            .orElseThrow(() -> new IllegalArgumentException("Title not found"));

        user.getCharacterStatus().setTitle(title);
    }

    @Transactional
    public void updateCharacterStatus(String studentId, RequestStatusDTO requestDto){
        User user = userRepository.findByStudentId(studentId)
            .orElseThrow(() -> new IllegalArgumentException("User not found"));
        CharacterStatus characterStatus = characterStatusRepository.findById(user.getId())
            .orElseThrow(() -> new IllegalArgumentException("Character not found"));

        // if (requestDto.getGrade() != null){
        //     characterStatus.setGrade(requestDto.getGrade());
        // }
        // else if (requestDto.getStress() != null){
        //     characterStatus.setFocus(requestDto.getFocus());
        // }
        // if (requestDto.getHappiness() != null){
        //     characterStatus.setHappiness(requestDto.getHappiness());
        // }
        // if (requestDto.getFocus() != null){
        //     characterStatus.setFocus(requestDto.getFocus());
        // }
        // if (requestDto.getAcademicAbility() != null){
        //     characterStatus.setAcademicAbility(requestDto.getAcademicAbility());
        // }
        characterStatusRepository.save(characterStatus);
    }
}
