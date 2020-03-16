package com.ailian.service.impl;

import com.ailian.bean.Role;
import com.ailian.dao.IRoleDao;
import com.ailian.service.IRoleService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RoleServiceImpl implements IRoleService {

    @Autowired
    private IRoleDao roleDao;

    public void saveRole(Role role) {
        roleDao.saveRole(role);
    }

    public void saveRoleAndPermission(String roleCode, String permissionCode) {
        roleDao.saveRoleAndPermission(roleCode, permissionCode);
    }

    public void saveRoleAndPermissions(String roleCode, String[] permissionCodes) {
        for (String permissionCode : permissionCodes) {
            roleDao.saveRoleAndPermission(roleCode, permissionCode);
        }
    }

    public List<Role> findRoleByUserCode(String userCode) {
        return roleDao.findRoleByUserCode(userCode);
    }

    public List<Role> findRoleByNotUserCode(String userCode) {
        return roleDao.findRoleByNotUserCode(userCode);
    }

    public List<Role> findAll(Integer page, Integer pageSize) {
        PageHelper.startPage(page, pageSize);
        return roleDao.findAll();
    }

    public Role findRoleByNotPermission(String code) {
        return roleDao.findRoleByNotPermission(code);
    }
}
