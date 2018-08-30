package com.obsez.zag.service.swuser.domain;

/**
 * Created by hedzr on 2017/4/20.
 */
public class LoginReq {
    private String unionid;
    private int accType;

    public LoginReq() {
    }

    public LoginReq(String unionid,  int accType) {
        this.unionid = unionid;
        this.accType = accType;
    }

    public String getUnionid() {
        return unionid;
    }

    public void setUnionid(String unionid) {
        this.unionid = unionid;
    }

    public int getAccType() {
        return accType;
    }

    public void setAccType(int accType) {
        this.accType = accType;
    }

    @Override
    public String toString() {
        return "LoginReq{" +
                "unionid='" + unionid + '\'' +
                ", accType=" + accType +
                '}';
    }
}
