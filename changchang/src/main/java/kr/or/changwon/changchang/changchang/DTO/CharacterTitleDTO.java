package kr.or.changwon.changchang.changchang.DTO;

import kr.or.changwon.changchang.changchang.entity.CharacterTitle;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CharacterTitleDTO {
    private Long id;
    private String name;
    private boolean owned;
    private boolean inUse;

    public CharacterTitleDTO(CharacterTitle characterTitle) {
        this.id = characterTitle.getTitle().getId();
        this.name = characterTitle.getTitle().getName();
        this.owned = characterTitle.isOwned();
        this.inUse = characterTitle.isInUse();
    }
}
