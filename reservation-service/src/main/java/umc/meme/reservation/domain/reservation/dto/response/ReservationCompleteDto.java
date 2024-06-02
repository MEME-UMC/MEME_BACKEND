package umc.meme.reservation.domain.reservation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import umc.meme.reservation.domain.reservation.entity.Reservation;
import global.enums.DayOfWeek;
import global.enums.Times;

import java.time.LocalDate;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReservationCompleteDto {
    private Long reservationId;
    private String makeupName;
    private String artistNickName;
    private String location; //장소
    private LocalDate reservationDate; //날짜
    private DayOfWeek dayOfWeek; //요일
    private Times times; //시간

    public static ReservationCompleteDto from(Portfolio portfolio, Reservation reservation){
        AvailableTime availableTime = reservation.getAvailableTime();
        return ReservationCompleteDto.builder()
                .reservationId(reservation.getReservationId())
                .makeupName(portfolio.getMakeupName())
                .artistNickName(portfolio.getArtist().getNickname())
                .location(reservation.getLocation())
                .reservationDate(availableTime.getDate())
                .dayOfWeek(availableTime.getDayOfWeek())
                .times(availableTime.getTimes())
                .build();
    }

}
