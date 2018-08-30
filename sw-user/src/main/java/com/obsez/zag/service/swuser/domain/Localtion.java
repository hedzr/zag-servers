package com.obsez.zag.service.swuser.domain;

import java.util.Date;

/**
 * Created by hedzr on 2018/4/16.
 */
public class Localtion {
    private int id;
    private int uid;
    private String order_id;
    private String longitude;
    private String latitude;
    private String city;
    private Date time;

    public Localtion() {
    }
    public Localtion(int id, int uid, String order_id, String longitude, String latitude, String city, Date time) {
        this.id = id;
        this.uid = uid;
        this.order_id = order_id;
        this.longitude = longitude;
        this.latitude = latitude;
        this.city = city;
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Localtion{" +
                "id=" + id +
                ", uid=" + uid +
                ", order_id='" + order_id + '\'' +
                ", longitude='" + longitude + '\'' +
                ", latitude='" + latitude + '\'' +
                ", city='" + city + '\'' +
                ", time=" + time +
                '}';
    }
}
