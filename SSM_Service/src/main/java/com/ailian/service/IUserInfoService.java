package com.ailian.service;

import com.ailian.bean.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface IUserInfoService extends UserDetailsService {

    /**
     * 添加用户信息
     * @param userInfo
     */
    void saveUser(UserInfo userInfo);

    void saveUserAndRole(String userCode, String roleCode);

    void saveUserAndRoles(String userCode, String[] roleCodes);
    /**
     * 查询所有用户信息，并使用pageHelper进行分页
     * @param page
     * @param pageSize
     * @return
     */
    List<UserInfo> findAll(Integer page, Integer pageSize);

    /**
     * 根据用户名、用户密码，查询用户信息
     */
    UserInfo findUserByUserNameAndPwd(String userName, String password);

    /**
     * 根据用户名，查询用户信息
     */
    UserInfo findUserByUserName(String userName);

    UserInfo findUserByCode(String code);

    UserInfo findUserByNotRole(String code);
}
