package umc.meme.reservation.global.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import umc.meme.reservation.global.ErrorStatus;

@Getter
@AllArgsConstructor
public class GlobalException extends RuntimeException {
    private final ErrorStatus errorStatus;
}
