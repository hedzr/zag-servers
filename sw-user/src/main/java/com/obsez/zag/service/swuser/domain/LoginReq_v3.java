package com.obsez.zag.service.swuser.domain;

/**
 * Created by hedzr on 2017/4/20.
 */
public class LoginReq_v3 {
    private String unionid;
    private int accType;
    private String appid;
    public LoginReq_v3() {
    }

    public LoginReq_v3(String unionid, int accType, String appid) {
        this.unionid = unionid;
        this.accType = accType;
        this.appid = appid;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
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
        return "LoginReq_v3{" +
                "unionid='" + unionid + '\'' +
                ", accType=" + accType +
                ", appid='" + appid + '\'' +
                '}';
    }
}
