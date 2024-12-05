package kr.or.changwon.changchang.changchang.DTO;

import kr.or.changwon.changchang.changchang.entity.Schedule;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ScheduleDTO {
    private String dayOfWeek;
    private String startTime;
    private String endTime;    

    public ScheduleDTO(Schedule schedule) {
        this.dayOfWeek = schedule.getDayOfWeek();
        this.startTime = schedule.getStartTime();
        this.endTime = schedule.getEndTime();
    }
}
