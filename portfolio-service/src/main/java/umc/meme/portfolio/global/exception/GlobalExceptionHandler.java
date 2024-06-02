package umc.meme.portfolio.global.exception;

import umc.meme.portfolio.global.ErrorStatus;

public class GlobalExceptionHandler extends GlobalException{
    public GlobalExceptionHandler(ErrorStatus errorStatus) {
        super(errorStatus);
    }
}
