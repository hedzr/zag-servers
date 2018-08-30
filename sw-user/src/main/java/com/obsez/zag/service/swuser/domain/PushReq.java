package com.obsez.zag.service.swuser.domain;

/**
 * Created by hedzr on 2017/4/28.
 */
public class PushReq {
    private String pushid;
    private String channelid;
    private int uid;
    public PushReq() {
    }

    public PushReq(String pushid, String channelid, int uid) {
        this.pushid = pushid;
        this.channelid = channelid;
        this.uid = uid;
    }

    public String getPushid() {
        return pushid;
    }

    public void setPushid(String pushid) {
        this.pushid = pushid;
    }

    public String getChannelid() {
        return channelid;
    }

    public void setChannelid(String channelid) {
        this.channelid = channelid;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    @Override
    public String toString() {
        return "PushReq{" +
                "pushid='" + pushid + '\'' +
                ", channelid='" + channelid + '\'' +
                ", uid=" + uid +
                '}';
    }
}
