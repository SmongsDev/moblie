package kr.or.changwon.changchang.changchang.DTO;

import java.util.List;
import java.util.stream.Collectors;

import kr.or.changwon.changchang.changchang.entity.CharacterStatus;
import kr.or.changwon.changchang.changchang.entity.Title;
import kr.or.changwon.changchang.changchang.entity.User;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class CharacterStatusDTO {
    private String username;
    private String password;
    private int grade;
    private int stress;
    private int happiness;
    private int focus;
    private int academicAbility; 
    private TitleDTO title;
    private List<TitleDTO> availableTitles;

    public CharacterStatusDTO(User user, CharacterStatus characterStatus, List<Title> titles) {
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.grade = characterStatus.getGrade();
        this.stress = characterStatus.getStress();
        this.happiness = characterStatus.getHappiness();  
        this.focus = characterStatus.getFocus();
        this.academicAbility = characterStatus.getAcademicAbility();
        this.title = new TitleDTO(characterStatus.getTitle());
        this.availableTitles = titles.stream()
            .map(TitleDTO::new)
            .collect(Collectors.toList());
    }
}