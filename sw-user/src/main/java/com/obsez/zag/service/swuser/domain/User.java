package com.obsez.zag.service.swuser.domain;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * Created by hedzr on 15/6/3.
 */
@XmlRootElement
public class User implements Serializable{

    private int userId;

    private int accType;//接入类型 0 微信 1 支付宝

    private String regTime; //注册时间

    private String noticephone; //绑定手机号码

    private String channelId;//APP百度推送

    private String pushId;//APP百度推送

    private String password;//密码

    private String userLevelname; //等级名称

    private String userLevel;//等级

    private String username; //微信Id

    private double balance;//余额

    private double mealDiscount;//打折率

    private String headImg;//头像

    private String nickName;//昵称

    private String sex;//性别

    private String isnew;//是否是新用户

    private int burrencyBeans;

    private int burrencyBeansDiscount;

    private String city;//城市

    private String phone;//电话号码


    public User() {
        this.regTime = "";
        this.noticephone = "";
    }

    public User(String username,String regTime,String nickName, String sex,String headImg,String city,int accType) {
        this.username = username;
        this.regTime = regTime;
        this.nickName = nickName;
        this.sex = sex;
        this.headImg = headImg;
        this.city = city;
        this.accType=accType;
    }

    public User(int userId, String regTime, String noticephone, String channelId, String pushId, String password, String userLevelname, String userLevel, String username, double balance, double mealDiscount, String headImg, String nickName, String sex, String isnew, int burrencyBeans, int burrencyBeansDiscount, String city, String phone) {
        this.userId = userId;
        this.regTime = regTime;
        this.noticephone = noticephone;
        this.channelId = channelId;
        this.pushId = pushId;
        this.password = password;
        this.userLevelname = userLevelname;
        this.userLevel = userLevel;
        this.username = username;
        this.balance = balance;
        this.mealDiscount = mealDiscount;
        this.headImg = headImg;
        this.nickName = nickName;
        this.sex = sex;
        this.isnew = isnew;
        this.burrencyBeans = burrencyBeans;
        this.burrencyBeansDiscount = burrencyBeansDiscount;
        this.city = city;
        this.phone = phone;
    }

    public int getAccType() {
        return accType;
    }

    public void setAccType(int accType) {
        this.accType = accType;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
    public int getBurrencyBeansDiscount() {
        return burrencyBeansDiscount;
    }

    public void setBurrencyBeansDiscount(int burrencyBeansDiscount) {
        this.burrencyBeansDiscount = burrencyBeansDiscount;
    }


    public String getRegTime() {
        return regTime;
    }

    public void setRegTime(String regTime) {
        this.regTime = regTime;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getNoticephone() {
        return noticephone;
    }

    public void setNoticephone(String noticephone) {
        this.noticephone = noticephone;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserLevelname() {
        return userLevelname;
    }

    public void setUserLevelname(String userLevelname) {
        this.userLevelname = userLevelname;
    }

    public String getUserLevel() {
        return userLevel;
    }

    public void setUserLevel(String userLevel) {
        this.userLevel = userLevel;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getMealDiscount() {
        return mealDiscount;
    }

    public void setMealDiscount(double mealDiscount) {
        this.mealDiscount = mealDiscount;
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

    public String getIsnew() {
        return isnew;
    }

    public void setIsnew(String isnew) {
        this.isnew = isnew;
    }

    public int getBurrencyBeans() {
        return burrencyBeans;
    }

    public void setBurrencyBeans(int burrencyBeans) {
        this.burrencyBeans = burrencyBeans;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", regTime='" + regTime + '\'' +
                ", noticephone='" + noticephone + '\'' +
                ", channelId='" + channelId + '\'' +
                ", pushId='" + pushId + '\'' +
                ", password='" + password + '\'' +
                ", userLevelname='" + userLevelname + '\'' +
                ", userLevel='" + userLevel + '\'' +
                ", username='" + username + '\'' +
                ", balance=" + balance +
                ", mealDiscount=" + mealDiscount +
                ", headImg='" + headImg + '\'' +
                ", nickName='" + nickName + '\'' +
                ", sex='" + sex + '\'' +
                ", isnew='" + isnew + '\'' +
                ", burrencyBeans=" + burrencyBeans +
                ", burrencyBeansDiscount=" + burrencyBeansDiscount +
                ", city='" + city + '\'' +
                ", accType='" + accType + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
