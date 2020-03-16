package com.ailian.service.impl;

import com.ailian.bean.Member;
import com.ailian.dao.IMemberDao;
import com.ailian.service.IMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MemberServiceImpl implements IMemberService {

    @Autowired
    private IMemberDao memberDao;

    public List<Member> findAll() {
        return memberDao.findAll();
    }

    public Member findMemberByCode(String code) {
        return memberDao.findMemberByCode(code);
    }
}
