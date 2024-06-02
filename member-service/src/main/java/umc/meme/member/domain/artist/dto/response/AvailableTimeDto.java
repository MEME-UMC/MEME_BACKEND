package umc.meme.member.domain.artist.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import umc.meme.member.domain.artist.entity.AvailableTime;
import global.enums.DayOfWeek;
import global.enums.Times;

import java.time.LocalDate;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AvailableTimeDto {
    private Long availableTimeId;
    private LocalDate date; //날짜
    private DayOfWeek dayOfWeek; //요일
    private Times times;

    static public AvailableTimeDto from(AvailableTime availableTime){
        return AvailableTimeDto.builder()
                .availableTimeId(availableTime.getAvailableTimeId())
                .date(availableTime.getDate())
                .dayOfWeek(availableTime.getDayOfWeek())
                .times(availableTime.getTimes())
                .build();
    }
}
