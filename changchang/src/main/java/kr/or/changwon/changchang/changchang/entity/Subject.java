package kr.or.changwon.changchang.changchang.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String scheduleInfo; 

    @ManyToMany(mappedBy = "subjects")
    private List<User> users = new ArrayList<>();
    
    @OneToMany(mappedBy = "subject", cascade = CascadeType.ALL)
    private List<AssignmentStatus> assignmentStatuses = new ArrayList<>();
}
