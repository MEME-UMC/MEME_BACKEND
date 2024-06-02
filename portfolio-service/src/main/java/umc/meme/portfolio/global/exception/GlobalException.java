package umc.meme.portfolio.global.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import umc.meme.portfolio.global.ErrorStatus;

@Getter
@AllArgsConstructor
public class GlobalException extends RuntimeException {
    private final ErrorStatus errorStatus;
}
