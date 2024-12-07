package kr.or.changwon.changchang.changchang.service;

import jakarta.transaction.Transactional;
import kr.or.changwon.changchang.changchang.DTO.CharacterTitleDTO;
import kr.or.changwon.changchang.changchang.DTO.requestDTO.RequestStatusDTO;
import kr.or.changwon.changchang.changchang.entity.CharacterStatus;
import kr.or.changwon.changchang.changchang.entity.CharacterTitle;
import kr.or.changwon.changchang.changchang.entity.Title;
import kr.or.changwon.changchang.changchang.entity.User;
import kr.or.changwon.changchang.changchang.repository.CharacterStatusRepository;
import kr.or.changwon.changchang.changchang.repository.CharacterTitleRepository;
import kr.or.changwon.changchang.changchang.repository.TitleRepository;
import kr.or.changwon.changchang.changchang.repository.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

@Service
public class CharacterStatusService {

    private final UserRepository userRepository;
    private final CharacterStatusRepository characterStatusRepository;
    private final CharacterTitleRepository characterTitleRepository;
    private final TitleRepository titleRepository;

    public CharacterStatusService(UserRepository userRepository, CharacterStatusRepository characterStatusRepository, CharacterTitleRepository characterTitleRepository, TitleRepository titleRepository){
        this.titleRepository = titleRepository;
        this.characterStatusRepository = characterStatusRepository;
        this.characterTitleRepository = characterTitleRepository;
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

        characterStatus.setGrade(requestDto.getGrade());
        characterStatus.setStress(requestDto.getStress());
        characterStatus.setHappiness(requestDto.getHappiness());
        characterStatus.setFocus(requestDto.getFocus());
        characterStatus.setAcademicAbility(requestDto.getAcademicAbility());
        
        // Optional.ofNullable(requestDto.getGrade()).ifPresent(characterStatus::setGrade);
        // Optional.ofNullable(requestDto.getStress()).ifPresent(characterStatus::setStress);
        // Optional.ofNullable(requestDto.getHappiness()).ifPresent(characterStatus::setHappiness);
        // Optional.ofNullable(requestDto.getFocus()).ifPresent(characterStatus::setFocus);
        // Optional.ofNullable(requestDto.getAcademicAbility()).ifPresent(characterStatus::setAcademicAbility);
        
        characterStatusRepository.save(characterStatus);
    }

    @Transactional
    public void changeCurrentTitle(CharacterStatus characterStatus, Title newTitle) {
        // 기존 Title 해제
        characterStatus.getCharacterTitles().forEach(ct -> ct.setInUse(false));

        // 새 Title 활성화
        characterStatus.getCharacterTitles().stream()
            .filter(ct -> ct.getTitle().equals(newTitle))
            .findFirst()
            .ifPresent(ct -> ct.setInUse(true));

        // 캐릭터의 현재 Title 업데이트
        characterStatus.setTitle(newTitle);
        characterStatusRepository.save(characterStatus);
    }


    // 캐릭터가 소유한 Title 리스트 가져오기
    @Transactional
    public List<CharacterTitleDTO> getCharacterTitles(String studentId) {
        User user = userRepository.findByStudentId(studentId)
            .orElseThrow(() -> new IllegalArgumentException("User not found"));

        CharacterStatus character = characterStatusRepository.findById(user.getId())
            .orElseThrow(() -> new IllegalArgumentException("Character not found"));

        return character.getCharacterTitles().stream()
                .map(CharacterTitleDTO::new)
                .collect(Collectors.toList());
    }

    // 캐릭터에 Title 추가 (소유 처리)
    @Transactional
    public void addTitleToCharacter(String studentId, Long titleId) {
        User user = userRepository.findByStudentId(studentId)
            .orElseThrow(() -> new IllegalArgumentException("User not found"));

        CharacterStatus character = characterStatusRepository.findById(user.getId())
            .orElseThrow(() -> new IllegalArgumentException("Character not found"));

        Title title = titleRepository.findById(titleId)
                .orElseThrow(() -> new IllegalArgumentException("Title not found"));

        // 이미 소유한 Title인지 확인
        boolean alreadyOwned = character.getCharacterTitles().stream()
                .anyMatch(ct -> ct.getTitle().equals(title) && ct.isOwned());

        if (alreadyOwned) {
            throw new IllegalStateException("Character already owns this Title.");
        }

        // 새로운 CharacterTitle 생성
        CharacterTitle characterTitle = new CharacterTitle();
        characterTitle.setCharacterStatus(character);
        characterTitle.setTitle(title);
        characterTitle.setOwned(true);
        characterTitle.setInUse(false);

        characterTitleRepository.save(characterTitle);
    }

    // 현재 사용 중인 Title 변경
    @Transactional
    public void changeCurrentTitle(String studentId, Long titleId) {
        User user = userRepository.findByStudentId(studentId)
            .orElseThrow(() -> new IllegalArgumentException("User not found"));

        CharacterStatus character = characterStatusRepository.findById(user.getId())
            .orElseThrow(() -> new IllegalArgumentException("Character not found"));

        Title newTitle = titleRepository.findById(titleId)
            .orElseThrow(() -> new IllegalArgumentException("Title not found"));

        // 모든 Title의 inUse 상태를 false로 변경
        character.getCharacterTitles().forEach(ct -> ct.setInUse(false));

        // 해당 Title의 inUse 상태를 true로 변경
        CharacterTitle characterTitle = character.getCharacterTitles().stream()
                .filter(ct -> ct.getTitle().equals(newTitle))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Character does not own this Title"));

        characterTitle.setInUse(true);

        // 캐릭터의 현재 Title 업데이트
        character.setTitle(newTitle);
        characterStatusRepository.save(character);
    }
}