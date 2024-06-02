package umc.meme.member.global.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import umc.meme.member.global.ErrorStatus;

@Getter
@AllArgsConstructor
public class GlobalException extends RuntimeException {
    private final ErrorStatus errorStatus;
}
