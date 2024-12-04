package kr.or.changwon.changchang.changchang.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Title {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private String rarity;
    private String conditions;
}