package kr.or.changwon.changchang.changchang.service;

import jakarta.transaction.Transactional;
import kr.or.changwon.changchang.changchang.entity.Title;
import kr.or.changwon.changchang.changchang.entity.User;
import kr.or.changwon.changchang.changchang.repository.TitleRepository;
import kr.or.changwon.changchang.changchang.repository.UserRepository;

import org.springframework.stereotype.Service;

@Service
public class CharacterStatusService {

    private final UserRepository userRepository;
    private final TitleRepository titleRepository;

    public CharacterStatusService(UserRepository userRepository, TitleRepository titleRepository){
        this.titleRepository = titleRepository;
        this.userRepository = userRepository;
    }

    @Transactional
    public void equipTitle(Long userId, Long titleId) {
        User user = userRepository.findById(userId)
            .orElseThrow(() -> new IllegalArgumentException("사용자를 찾을 수 없습니다."));

        Title title = titleRepository.findById(titleId)
            .orElseThrow(() -> new IllegalArgumentException("칭호를 찾을 수 없습니다."));

        user.getCharacterStatus().setTitle(title);
    }
}
