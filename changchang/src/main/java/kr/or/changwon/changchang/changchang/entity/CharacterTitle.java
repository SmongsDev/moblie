package kr.or.changwon.changchang.changchang.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class CharacterTitle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 소유 여부
    private boolean owned;

    // 현재 사용 여부
    private boolean inUse;

    @ManyToOne
    @JoinColumn(name = "character_status_id")
    private CharacterStatus characterStatus;

    @ManyToOne
    @JoinColumn(name = "title_id")
    private Title title;
}
