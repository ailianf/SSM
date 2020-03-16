package com.ailian.service.impl;

import com.ailian.bean.Permission;
import com.ailian.dao.IPermissionDao;
import com.ailian.service.IPermissionService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PermissionServiceImpl implements IPermissionService {

    @Autowired
    private IPermissionDao permissionDao;

    public void savePermission(Permission permission) {
        permissionDao.savePermission(permission);
    }

    public List<Permission> findAll(Integer page, Integer pageSize) {
        PageHelper.startPage(page, pageSize);
        return permissionDao.findAll();
    }

    public List<Permission> findPermissionByCode(String code) {
        return permissionDao.findPermissionByCode(code);
    }

    public List<Permission> findPermissionByRoleCode(String roleCode) {
        return permissionDao.findPermissionByRoleCode(roleCode);
    }
}
