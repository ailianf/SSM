package com.ailian.dao;

import com.ailian.bean.Member;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IMemberDao {

    /**
     * 查询所有的会员信息
     * @return
     */
    @Select(value = {"select * from member "})
    List<Member> findAll();

    /**
     * 根据code查询会员信息
     * @return
     */
    @Select(value = {"select * from member where code = #{code} "})
    Member findMemberByCode(String code);
}
