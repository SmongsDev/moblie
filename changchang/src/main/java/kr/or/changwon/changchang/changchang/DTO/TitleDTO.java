package kr.or.changwon.changchang.changchang.DTO;

import kr.or.changwon.changchang.changchang.entity.Title;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TitleDTO {
    private String name;
    private String description;
    private String rarity;
    private String conditions;

    public TitleDTO(Title title) {
        this.name = title.getName();
        this.description = title.getDescription();
        this.rarity = title.getRarity();
        this.conditions = title.getConditions();
    }
}
