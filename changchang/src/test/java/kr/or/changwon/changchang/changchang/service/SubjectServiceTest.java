package kr.or.changwon.changchang.changchang.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import kr.or.changwon.changchang.changchang.entity.Subject;
import kr.or.changwon.changchang.changchang.repository.SubjectRepository;

@SpringBootTest
public class SubjectServiceTest {
    
    @Autowired
    private SubjectRepository subjectRepository;
    
    @Test
    public void testEquipTitle() {        
        Subject subj1 = new Subject();
        subj1.setName("고급자료구조");
        subj1.setScheduleInfo("Monday 10:30-12:00, Wednesday 9:00-10:30");
        subjectRepository.save(subj1);
        
        Subject subj2 = new Subject();
        subj2.setName("모바일프로그래밍");
        subj2.setScheduleInfo("Monday 12:30-14:00, Thursday 14:00-15:30");
        subjectRepository.save(subj2);
        
        Subject subj3 = new Subject();
        subj3.setName("논리설계");
        subj3.setScheduleInfo("Tuesday 9:00-10:30, Thursday 10:30-12:00");
        subjectRepository.save(subj3);

        Subject subj4 = new Subject();
        subj4.setName("컴퓨터그래픽스");
        subj4.setScheduleInfo("Tuesday 10:30-12:00, Thursday 9:00-10:30");
        subjectRepository.save(subj4);

        Subject subj5 = new Subject();
        subj5.setName("프로그래밍언어론");
        subj5.setScheduleInfo("Tuesday 15:00-16:30, Thursday 16:30-18:00");
        subjectRepository.save(subj5);
        
        Subject subj6 = new Subject();
        subj6.setName("데이터베이스언어실습");
        subj6.setScheduleInfo("Friday 12:00-15:00");
        subjectRepository.save(subj6);

    }
}
