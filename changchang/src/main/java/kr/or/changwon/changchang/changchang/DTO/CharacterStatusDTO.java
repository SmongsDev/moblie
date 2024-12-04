package kr.or.changwon.changchang.changchang.DTO;

import kr.or.changwon.changchang.changchang.entity.CharacterStatus;
import kr.or.changwon.changchang.changchang.entity.User;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class CharacterStatusDTO {
    private String username;
    private int grade;
    private int health;
    private int intel;
    private int stress;
    private int happiness;
    private int focus;    
    private int timeManagement;  
    private int leadership;
    private int creativity;
    private int socialSkills; 
    private int academicAbility; 
    private TitleDTO title;

    public CharacterStatusDTO(User user, CharacterStatus characterStatus) {
        this.username = user.getUsername();
        this.grade = characterStatus.getGrade();
        this.health = characterStatus.getHealth();
        this.intel = characterStatus.getIntel();
        this.stress = characterStatus.getStress();
        this.happiness = characterStatus.getHappiness();  
        this.focus = characterStatus.getFocus();          
        this.timeManagement = characterStatus.getTimeManagement();
        this.leadership = characterStatus.getLeadership();        
        this.creativity = characterStatus.getCreativity(); 
        this.socialSkills = characterStatus.getSocialSkills();
        this.academicAbility = characterStatus.getAcademicAbility();
        this.title = new TitleDTO(characterStatus.getTitle());
    }
}