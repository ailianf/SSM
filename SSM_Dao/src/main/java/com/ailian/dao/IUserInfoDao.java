package com.ailian.dao;

import com.ailian.bean.Role;
import com.ailian.bean.UserInfo;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUserInfoDao {

    /**
     * 添加用户信息
     * @param userInfo
     */
    @Insert("insert into " +
            "user(code, email, userName, password, phoneNum, status) " +
            "values(replace(uuid(), '-', ''), #{email}, #{userName}, #{password}, #{phoneNum}, #{status}) ")
    void saveUser(UserInfo userInfo);

    @Insert("insert into user_role(userCode, roleCode) values(#{userCode}, #{roleCode}) ")
    void saveUserAndRole(@Param("userCode") String userCode, @Param("roleCode") String roleCode);

    @Select("select * from user ")
    @Results(
            value = {
                    @Result(id = true, property = "code", column = "code"),
                    @Result(property = "email", column = "email"),
                    @Result(property = "userName", column = "userName"),
                    @Result(property = "password", column = "password"),
                    @Result(property = "status", column = "status"),
                    @Result(property = "roles", column = "code", javaType = List.class,
                            many = @Many(select = "com.ailian.dao.IRoleDao.findRoleByUserCode", fetchType = FetchType.LAZY))
            }
    )
    List<UserInfo> findAll();

    @Select("select * from user where userName = #{userName} and password = #{password} ")
    @Results(
            value = {
                    @Result(id = true, property = "code", column = "code"),
                    @Result(property = "email", column = "email"),
                    @Result(property = "userName", column = "userName"),
                    @Result(property = "password", column = "password"),
                    @Result(property = "status", column = "status"),
                    @Result(property = "roles", column = "code", javaType = List.class,
                            many = @Many(select = "com.ailian.dao.IRoleDao.findRoleByUserCode", fetchType = FetchType.LAZY))
            }
    )
    UserInfo findUserByUserNameAndPwd(String userName, String password);

    @Select("select * from user where userName = #{userName} ")
    @Results(
            id = "userAndRoleMap",
            value = {
                    @Result(id = true, property = "code", column = "code"),
                    @Result(property = "email", column = "email"),
                    @Result(property = "userName", column = "userName"),
                    @Result(property = "password", column = "password"),
                    @Result(property = "status", column = "status"),
                    @Result(property = "roles", column = "code", javaType = List.class,
                            many = @Many(select = "com.ailian.dao.IRoleDao.findRoleByUserCode", fetchType = FetchType.LAZY))
            }
    )
    UserInfo findUserByUserName(String userName);

    @Select("select * from user where code = #{code} ")
    @ResultMap("userAndRoleMap")
    UserInfo findUserByCode(String code);

    @Select("select * from user where code = #{code}")
    @Results(
            value = {
                    @Result(id = true, property = "code", column = "code"),
                    @Result(property = "email", column = "email"),
                    @Result(property = "userName", column = "userName"),
                    @Result(property = "password", column = "password"),
                    @Result(property = "status", column = "status"),
                    @Result(property = "roles", column = "code", javaType = List.class,
                            many = @Many(select = "com.ailian.dao.IRoleDao.findRoleByNotUserCode", fetchType = FetchType.LAZY))
            }
    )
    UserInfo findUserByNotRole(String code);


}
