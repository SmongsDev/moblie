package kr.or.changwon.changchang.changchang.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import kr.or.changwon.changchang.changchang.entity.CharacterStatus;

public interface CharacterStatusRepository extends JpaRepository<CharacterStatus, Long> {
    
}
