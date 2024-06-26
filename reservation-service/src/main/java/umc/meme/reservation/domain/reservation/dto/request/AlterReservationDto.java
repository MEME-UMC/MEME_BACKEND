package umc.meme.reservation.domain.reservation.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import global.enums.Status;

@Data
public class AlterReservationDto {
    @NotBlank(message = "reservationId를 입력해주세요.")
    private Long reservationId;
    @NotBlank(message = "status를 입력해주세요.")
    private Status status;
}
