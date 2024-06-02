package umc.meme.member.global.exception;
import umc.meme.member.global.ErrorStatus;

public class GlobalExceptionHandler extends GlobalException{
    public GlobalExceptionHandler(ErrorStatus errorStatus) {
        super(errorStatus);
    }
}
