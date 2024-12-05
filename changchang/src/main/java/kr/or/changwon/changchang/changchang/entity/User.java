package kr.or.changwon.changchang.changchang.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String studentId;
    private String username;
    private String password;
    private String role;
    private Long points;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "character_status_id", referencedColumnName = "id")
    private CharacterStatus characterStatus;

    @ManyToMany
    @JoinTable(
        name = "user_subject",
        joinColumns = @JoinColumn(name = "user_id"),
        inverseJoinColumns = @JoinColumn(name = "subject_id")
    )
    private List<Subject> subjects = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<AssignmentStatus> assignmentStatuses = new ArrayList<>();

    @OneToMany
    private List<ToDo> todoLists = new ArrayList<>();
}