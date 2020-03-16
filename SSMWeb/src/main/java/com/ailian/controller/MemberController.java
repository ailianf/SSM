package com.ailian.controller;

import com.ailian.bean.Member;
import com.ailian.service.IMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/member")
public class MemberController {

    @Autowired
    private IMemberService memberService;

    @RequestMapping("/findMemberByCode")
    public ModelAndView findMemberByCode() {
        ModelAndView mv = new ModelAndView();
        Member member = memberService.findMemberByCode("1290ac46583811eab7e5001c42c0de6e");
        System.out.println(member);
        mv.setViewName("/test.jsp");
        return mv;
    }

}
