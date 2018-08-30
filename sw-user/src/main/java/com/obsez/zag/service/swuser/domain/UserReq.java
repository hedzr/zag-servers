package com.obsez.zag.service.swuser.domain;

/**
 * Created by hedzr on 2017/4/26.
 */
public class UserReq {

    private String unionid;

    private int accType;//接入类型 0 微信 1 支付宝

    private String channelId;//APP百度推送

    private String pushId;//APP百度推送

    private String username; //微信Id

    private String headImg;//头像

    private String nickName;//昵称

    private String sex;//性别

    private String city;//城市

    private String phone;//电话号码

    public UserReq() {
    }

    public UserReq(String unionid, int accType, String channelId, String pushId, String username, String headImg, String nickName, String sex, String city, String phone) {
        this.unionid = unionid;
        this.accType = accType;
        this.channelId = channelId;
        this.pushId = pushId;
        this.username = username;
        this.headImg = headImg;
        this.nickName = nickName;
        this.sex = sex;
        this.city = city;
        this.phone = phone;
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

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public String getPushId() {
        return pushId;
    }

    public void setPushId(String pushId) {
        this.pushId = pushId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getHeadImg() {
        return headImg;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "UserReq{" +
                "unionid='" + unionid + '\'' +
                ", accType=" + accType +
                ", channelId='" + channelId + '\'' +
                ", pushId='" + pushId + '\'' +
                ", username='" + username + '\'' +
                ", headImg='" + headImg + '\'' +
                ", nickName='" + nickName + '\'' +
                ", sex='" + sex + '\'' +
                ", city='" + city + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
