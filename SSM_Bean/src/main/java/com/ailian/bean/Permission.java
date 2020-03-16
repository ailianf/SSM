package com.ailian.bean;

import java.io.Serializable;
import java.util.List;

public class Permission implements Serializable {

    private String code; // 主键UUID
    private String permissionName; // 权限名
    private String url; // 资源路径

    private List<Role> roles;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "Permission{" +
                "code='" + code + '\'' +
                ", permissionName='" + permissionName + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
