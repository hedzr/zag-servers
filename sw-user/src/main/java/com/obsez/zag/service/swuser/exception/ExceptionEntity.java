package com.obsez.zag.service.swuser.exception;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by hedzr on 15/6/8.
 */
@XmlRootElement
public class ExceptionEntity {

    private int errCode;

    private String errMsg;

    public ExceptionEntity() {
        errCode = 0;
        errMsg = "";
    }

    public int getErrCode() {
        return errCode;
    }

    public void setErrCode(int errCode) {
        this.errCode = errCode;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    @Override
    public String toString() {
        return "ExceptionEntity{" +
                "错误代码=" + errCode +
                ", 错误信息='" + errMsg + '\'' +
                '}';
    }
}
