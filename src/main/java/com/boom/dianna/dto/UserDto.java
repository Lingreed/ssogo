package com.boom.dianna.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Author: lin.xj
 * Date: 2016-10-27
 * Description:
 */
public class UserDto implements Serializable {

    private long userId;
    private String userName;
    private String pwd;
    private Boolean enabled;
    private String info;
    private Date addTime;
    private Integer age;
    private String sex;
    private String province;
    private String city;
    private String area;
    private String phone;
    private String qq;
    private String yy;
    private List<AuthDto> auths;

    public UserDto() {
    }

    public UserDto(long userId, String userName, Boolean enabled, String info, Date addTime, Integer age, String sex, String province, String city, String area, String phone, String qq, String yy) {
        this.userId = userId;
        this.userName = userName;
        this.enabled = enabled;
        this.info = info;
        this.addTime = addTime;
        this.age = age;
        this.sex = sex;
        this.province = province;
        this.city = city;
        this.area = area;
        this.phone = phone;
        this.qq = qq;
        this.yy = yy;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getYy() {
        return yy;
    }

    public void setYy(String yy) {
        this.yy = yy;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public List<AuthDto> getAuths() {
        return auths;
    }

    public void setAuths(List<AuthDto> auths) {
        this.auths = auths;
    }
}
