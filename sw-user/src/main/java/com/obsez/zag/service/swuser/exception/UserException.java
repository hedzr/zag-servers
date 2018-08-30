package com.obsez.zag.service.swuser.exception;



/**
 * Created by hedzr on 15/6/5.
 */
public  class UserException extends RuntimeException {

    private static final String SW_EXCEPTION_PREFIX = "异常";

    protected ExceptionEntity exceptionEntity;

    public UserException() {
         exceptionEntity = new ExceptionEntity();
    }

    public UserException(int errCode, String errMsg) {
        this();
        exceptionEntity.setErrCode(errCode);
        exceptionEntity.setErrMsg(errMsg);
    }

    public ExceptionEntity getExceptionEntity() {
        return exceptionEntity;
    }
}
