package kr.or.changwon.changchang.changchang.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class AssignmentStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user; // 과제를 제출한 사용자

    @ManyToOne
    @JoinColumn(name = "subject_id", nullable = false)
    private Subject subject; // 과제와 연관된 과목

    private boolean submitted; // 과제 제출 여부
    private String deadline;
}
