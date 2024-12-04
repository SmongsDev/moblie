package kr.or.changwon.changchang.changchang.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class CharacterStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int grade;
    private int health;
    private int intel;
    private int stress;
    private int happiness;    // 행복도
    private int focus;        // 집중력
    private int timeManagement;  // 시간 관리 능력
    private int leadership;   // 리더십
    private int creativity;   // 창의성
    private int socialSkills; // 사회적 기술
    private int academicAbility;  // 학업 능력
    
    @ManyToOne
    @JoinColumn(name = "current_title_id", referencedColumnName = "id")
    private Title title;
}