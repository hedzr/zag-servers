package com.obsez.zag.service.swuser.domain;

/**
 * Created by hedzr on 2017/4/27.
 */
public class UpdatePhone {
    private String phone;
    private int uid;

    public UpdatePhone() {
    }

    public UpdatePhone(String phone, int uid) {
        this.phone = phone;
        this.uid = uid;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    @Override
    public String toString() {
        return "UpdatePhone{" +
                "phone='" + phone + '\'' +
                ", uid=" + uid +
                '}';
    }
}
