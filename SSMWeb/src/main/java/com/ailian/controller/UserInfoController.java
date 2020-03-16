package com.ailian.controller;

import com.ailian.bean.UserInfo;
import com.ailian.service.IPermissionService;
import com.ailian.service.IRoleService;
import com.ailian.service.IUserInfoService;
import com.ailian.utils.BCryptPasswordEncoderUtils;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserInfoController {

    @Autowired
    private IUserInfoService userInfoService;

    @RequestMapping(value = "/addUser.do", method = RequestMethod.GET)
    public ModelAndView addUser() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("userInfo-add");
        return mv;
    }

    @RequestMapping(value = "/addUser.do", method = RequestMethod.POST)
    public String addUser(UserInfo userInfo) {
        userInfo.setPassword(BCryptPasswordEncoderUtils.encode(userInfo.getPassword()));
        userInfoService.saveUser(userInfo);
        return "forward:/user/userList.do";
    }

    @RequestMapping("/userList.do")
    @RolesAllowed("ROLE_USER")
    public ModelAndView findUser(
            @RequestParam(name = "page", required = true, defaultValue = "1") Integer page,
            @RequestParam(name = "pageSize", required = true, defaultValue = "4") Integer pageSize) {
        ModelAndView mv = new ModelAndView();
        List<UserInfo> userInfos = userInfoService.findAll(page, pageSize);
        PageInfo pageInfo = new PageInfo(userInfos);
        mv.addObject("pageInfo", pageInfo);
        mv.setViewName("user-list");
        return mv;
    }

    @RequestMapping("/user_show.do")
    public ModelAndView user_show(@RequestParam(name = "code", required = true) String code) {
        ModelAndView mv = new ModelAndView();
        UserInfo userinfo = userInfoService.findUserByCode(code);
        mv.addObject("userInfo", userinfo);
        mv.setViewName("user-show");
        return mv;
    }

    @RequestMapping(value = {"/userAddRole.do"}, method = RequestMethod.GET)
    public ModelAndView userAddRole(@RequestParam(name = "code", required = true) String code) {
        ModelAndView mv = new ModelAndView();
        UserInfo userInfo = userInfoService.findUserByNotRole(code);
        mv.addObject("userInfo", userInfo);
        mv.setViewName("user-add-role");
        return mv;
    }

    @RequestMapping(value = {"/userAddRole.do"}, method = RequestMethod.POST)
    public String userAddRole(
            @RequestParam(name = "code", required = true) String code,
            @RequestParam(name = "ids", required = true) String[] ids) {
        userInfoService.saveUserAndRoles(code, ids);
        return "forward:/user/userList.do";
    }

}
