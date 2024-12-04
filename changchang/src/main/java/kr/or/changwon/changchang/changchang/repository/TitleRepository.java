package kr.or.changwon.changchang.changchang.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import kr.or.changwon.changchang.changchang.entity.Title;

public interface TitleRepository extends JpaRepository<Title, Long> {
    Optional<Title> findByName(String name);
}
