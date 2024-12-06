package kr.or.changwon.changchang.changchang.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Data
@Entity
public class Department {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String crawlUrl; // 크롤링 URL 필드
	private String linkPattern; // 링크 패턴 필드 추가

	@OneToMany(mappedBy = "department")
	@JsonManagedReference // 순환 참조 문제 해결
	private List<Notice> notices;
}