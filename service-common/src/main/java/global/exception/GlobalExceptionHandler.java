package global.exception;


import global.ErrorStatus;

public class GlobalExceptionHandler extends GlobalException {
    public GlobalExceptionHandler(ErrorStatus errorStatus) {
        super(errorStatus);
    }
}
