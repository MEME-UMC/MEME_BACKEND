package global.exception;

import global.ErrorStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public class GlobalException extends RuntimeException {
    private final ErrorStatus errorStatus;
}
