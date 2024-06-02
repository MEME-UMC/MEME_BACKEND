package umc.meme.reservation.global.exception;

import umc.meme.reservation.global.ErrorStatus;

public class GlobalExceptionHandler extends GlobalException{
    public GlobalExceptionHandler(ErrorStatus errorStatus) {
        super(errorStatus);
    }
}
