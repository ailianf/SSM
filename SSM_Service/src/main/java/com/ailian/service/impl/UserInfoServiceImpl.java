package com.ailian.service.impl;

import com.ailian.bean.Role;
import com.ailian.bean.UserInfo;
import com.ailian.dao.IUserInfoDao;
import com.ailian.service.IUserInfoService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("userInfoService")
@Transactional
public class UserInfoServiceImpl implements IUserInfoService {

    @Autowired
    private IUserInfoDao userInfoDao;

    public void saveUser(UserInfo userInfo) {
        userInfoDao.saveUser(userInfo);
    }

    public void saveUserAndRole(String userCode, String roleCode) {
        userInfoDao.saveUserAndRole(userCode, roleCode);
    }

    public void saveUserAndRoles(String userCode, String[] roleCodes) {
        for (String roleCode : roleCodes) {
            userInfoDao.saveUserAndRole(userCode, roleCode);
        }
    }

    public List<UserInfo> findAll(Integer page, Integer pageSize) {
        PageHelper.startPage(page, pageSize);
        return userInfoDao.findAll();
    }

    public UserInfo findUserByUserNameAndPwd(String userName, String password) {
        return userInfoDao.findUserByUserNameAndPwd(userName, password);
    }

    public UserInfo findUserByUserName(String userName) {
        return userInfoDao.findUserByUserName(userName);
    }

    public UserInfo findUserByCode(String code) {
        return userInfoDao.findUserByCode(code);
    }

    public UserInfo findUserByNotRole(String code) {
        return userInfoDao.findUserByNotRole(code);
    }

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo userInfo = userInfoDao.findUserByUserName(username);
        return new User(userInfo.getUserName(), userInfo.getPassword(), getAuthorities(userInfo.getRoles()));
    }

    public List<SimpleGrantedAuthority> getAuthorities(List<Role> roles) {
        List<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
        for (Role role : roles) {
            authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getRoleName().toUpperCase()));
        }
        return authorities;
    }

}
