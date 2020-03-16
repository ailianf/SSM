package com.ailian.service;

import com.ailian.bean.Member;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IMemberService {

    /**
     * 查询所有的会员信息
     * @return
     */
    List<Member> findAll();

    /**
     * 根据code查询会员信息
     * @return
     */
    Member findMemberByCode(String code);
}
