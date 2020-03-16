package com.ailian.bean;

import java.io.Serializable;
import java.util.List;

public class UserInfo implements Serializable {

    private String code; // 主键UUID
    private String email; // 飞空， 唯一
    private String userName; // 用户名
    private String password; // 密码（加密）
    private String phoneNum; // 电话
    private Integer status; // 状态 0：未开启；1：开启
    private String statusStr;

    private List<Role> roles;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getStatusStr() {
        // 状态 0：未开启；1：开启
        if (status != null) {
            if (status == 0) {
                statusStr = "未开启";
            } else if (status == 1) {
                statusStr = "开启";
            }
        }
        return statusStr;
    }

    public void setStatusStr(String statusStr) {
        this.statusStr = statusStr;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "code='" + code + '\'' +
                ", email='" + email + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                ", status=" + status +
                ", statusStr='" + statusStr + '\'' +
                '}';
    }
}
