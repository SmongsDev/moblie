package kr.or.changwon.changchang.changchang.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import kr.or.changwon.changchang.changchang.DTO.SubjectDTO;
import kr.or.changwon.changchang.changchang.entity.Schedule;
import kr.or.changwon.changchang.changchang.entity.Subject;
import kr.or.changwon.changchang.changchang.repository.ScheduleRepository;
import kr.or.changwon.changchang.changchang.repository.SubjectRepository;

@Service
public class SubjectService {

    private final SubjectRepository subjectRepository;
    private final ScheduleRepository scheduleRepository;

    public SubjectService(SubjectRepository subjectRepository, ScheduleRepository scheduleRepository) {
        this.subjectRepository = subjectRepository;
        this.scheduleRepository = scheduleRepository;
    }

    // Subject 생성
    @Transactional
    public Subject createSubject(SubjectDTO createSubjectDTO) {
        Subject subject = new Subject();
        subject.setName(createSubjectDTO.getSubjectName());

        // Schedule 리스트 추가
        List<Schedule> schedules = createSubjectDTO.getSchedules().stream()
                .map(dto -> {
                    Schedule schedule = new Schedule();
                    schedule.setDayOfWeek(dto.getDayOfWeek());
                    schedule.setStartTime(dto.getStartTime());
                    schedule.setEndTime(dto.getEndTime());
                    schedule.setSubject(subject);
                    return schedule;
                })
                .collect(Collectors.toList());

        subject.setSchedules(schedules);

        return subjectRepository.save(subject);
    }

    // 유저의 Subject 조회
    @Transactional
    public SubjectDTO getSubjectById(Long subjectId) {
        Subject subject = subjectRepository.findById(subjectId)
                .orElseThrow(() -> new RuntimeException("Subject not found"));

        SubjectDTO subjectDTO = new SubjectDTO(subject);
        return subjectDTO;
    }

    // 모든 Subject 조회
    @Transactional
    public List<SubjectDTO> getAllSubjects() {
        return subjectRepository.findAll()
                .stream()
                .map(SubjectDTO::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public void updateSubject(Long subjectId, SubjectDTO updateSubjectDTO) {
        Subject subject = subjectRepository.findById(subjectId)
                .orElseThrow(() -> new RuntimeException("Subject not found"));

        if (updateSubjectDTO.getSubjectName() != null) {
            subject.setName(updateSubjectDTO.getSubjectName());
        }

        if (updateSubjectDTO.getSchedules() != null) {
            // 기존 Schedule 삭제 후 새로 추가
            subject.getSchedules().clear();
            List<Schedule> updatedSchedules = updateSubjectDTO.getSchedules().stream()
                    .map(dto -> {
                        Schedule schedule = new Schedule();
                        schedule.setDayOfWeek(dto.getDayOfWeek());
                        schedule.setStartTime(dto.getStartTime());
                        schedule.setEndTime(dto.getEndTime());
                        schedule.setSubject(subject);
                        return schedule;
                    })
                    .collect(Collectors.toList());
            subject.getSchedules().addAll(updatedSchedules);
        }

        subjectRepository.save(subject);
    }
    
    // Subject 삭제
    public void deleteSubject(Long subjectId) {
        Subject subject = subjectRepository.findById(subjectId)
                .orElseThrow(() -> new RuntimeException("Subject not found"));
        subjectRepository.delete(subject);
    }
}

