package kr.or.changwon.changchang.changchang.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import kr.or.changwon.changchang.changchang.entity.Schedule;
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
        
        Schedule schedule1 = new Schedule();
        schedule1.setDayOfWeek("Monday");
        schedule1.setStartTime("10:30");
        schedule1.setEndTime("12:00");
        schedule1.setSubject(subj1);
        
        Schedule schedule2 = new Schedule();
        schedule2.setDayOfWeek("Wednesday");
        schedule2.setStartTime("9:00");
        schedule2.setEndTime("10:30");
        schedule2.setSubject(subj1);

        subj1.getSchedules().add(schedule1);
        subj1.getSchedules().add(schedule2);

        subjectRepository.save(subj1);
        
        // 모프
        Subject subj2 = new Subject();
        subj2.setName("모바일프로그래밍");
        
        Schedule schedule3 = new Schedule();
        schedule3.setDayOfWeek("Monday");
        schedule3.setStartTime("10:30");
        schedule3.setEndTime("12:00");
        schedule3.setSubject(subj2);
        
        Schedule schedule4 = new Schedule();
        schedule4.setDayOfWeek("Wednesday");
        schedule4.setStartTime("14:00");
        schedule4.setEndTime("15:30");
        schedule4.setSubject(subj2);

        subj2.getSchedules().add(schedule3);
        subj2.getSchedules().add(schedule4);

        subjectRepository.save(subj2);
        
        Subject subj3 = new Subject();
        subj3.setName("논리설계");

        Schedule schedule5 = new Schedule();
        schedule5.setDayOfWeek("Tuseday");
        schedule5.setStartTime("9:00");
        schedule5.setEndTime("10:30");
        schedule5.setSubject(subj3);
        
        Schedule schedule6 = new Schedule();
        schedule6.setDayOfWeek("Thursday");
        schedule6.setStartTime("10:30");
        schedule6.setEndTime("12:00");
        schedule6.setSubject(subj3);

        subj3.getSchedules().add(schedule5);
        subj3.getSchedules().add(schedule6);
        
        subjectRepository.save(subj3);

        Subject subj4 = new Subject();
        subj4.setName("컴퓨터그래픽스");
        
        Schedule schedule7 = new Schedule();
        schedule7.setDayOfWeek("Tuseday");
        schedule7.setStartTime("10:30");
        schedule7.setEndTime("12:00");
        schedule7.setSubject(subj4);
        
        Schedule schedule8 = new Schedule();
        schedule8.setDayOfWeek("Thursday");
        schedule8.setStartTime("9:00");
        schedule8.setEndTime("10:30");
        schedule8.setSubject(subj4);

        subj4.getSchedules().add(schedule7);
        subj4.getSchedules().add(schedule8);

        subjectRepository.save(subj4);

        Subject subj5 = new Subject();
        subj5.setName("프로그래밍언어론");
        
        Schedule schedule9 = new Schedule();
        schedule9.setDayOfWeek("Tuseday");
        schedule9.setStartTime("15:00");
        schedule9.setEndTime("16:30");
        schedule9.setSubject(subj5);
        
        Schedule schedule10 = new Schedule();
        schedule10.setDayOfWeek("Thursday");
        schedule10.setStartTime("16:30");
        schedule10.setEndTime("18:00");
        schedule10.setSubject(subj5);

        subj5.getSchedules().add(schedule9);
        subj5.getSchedules().add(schedule10);
        
        subjectRepository.save(subj5);
        
        Subject subj6 = new Subject();
        subj6.setName("데이터베이스언어실습");
        
        Schedule schedule11 = new Schedule();
        schedule11.setDayOfWeek("Friday");
        schedule11.setStartTime("12:00");
        schedule11.setEndTime("15:00");
        schedule11.setSubject(subj6);
        
        subj6.getSchedules().add(schedule11);
        
        subjectRepository.save(subj6);

    }
}
