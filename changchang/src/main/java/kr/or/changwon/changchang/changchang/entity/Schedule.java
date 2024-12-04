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
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String dayOfWeek; // 요일 (예: "Monday", "Wednesday")
    private String startTime; // 시작 시간 (예: "10:00")
    private String endTime;   // 종료 시간 (예: "12:00")

    @ManyToOne
    @JoinColumn(name = "subject_id")
    private Subject subject;

}