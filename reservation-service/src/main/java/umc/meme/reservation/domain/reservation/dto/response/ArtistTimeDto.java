package umc.meme.reservation.domain.reservation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import global.enums.DayOfWeek;
import global.enums.Times;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ArtistTimeDto {
    private DayOfWeek availableDayOfWeek;
    private Times availableTime;

    public static ArtistTimeDto from(DayOfWeek dayOfWeek, Times availableTime){
        return ArtistTimeDto.builder()
                .availableDayOfWeek(dayOfWeek)
                .availableTime(availableTime)
                .build();
    }
}
