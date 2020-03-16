package com.ailian.service;

import com.ailian.bean.Permission;

import java.util.List;

public interface IPermissionService {

    void savePermission(Permission permission);

    List<Permission> findAll(Integer page, Integer pageSize);

    List<Permission> findPermissionByCode(String code);

    List<Permission> findPermissionByRoleCode(String roleCode);
}
