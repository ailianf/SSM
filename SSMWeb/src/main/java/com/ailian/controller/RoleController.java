package com.ailian.controller;

import com.ailian.bean.Role;
import com.ailian.service.IRoleService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private IRoleService roleService;

    @RequestMapping(value = {"/addRole.do"}, method = RequestMethod.GET)
    public ModelAndView addRole() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("role-add");
        return mv;
    }

    @RequestMapping(value = {"/addRole.do"}, method = RequestMethod.POST)
    public String addRole(Role role) {
        roleService.saveRole(role);
        return "forward:/role/roleList.do";
    }

    @RequestMapping("/roleList.do")
    public ModelAndView findAll(
            @RequestParam(name = "page", required = true, defaultValue = "1") Integer page,
            @RequestParam(name = "pageSize", required = true, defaultValue = "4") Integer pageSize) {
        ModelAndView mv = new ModelAndView();
        List<Role> roles = roleService.findAll(page, pageSize);
        PageInfo pageInfo = new PageInfo(roles);
        mv.addObject("pageInfo", pageInfo);
        mv.setViewName("role-list");
        return mv;
    }

    @RequestMapping(value = {"/addRoleAndPermission.do"}, method = RequestMethod.GET)
    public ModelAndView addRoleAndPermission(@RequestParam(name = "code", required = true) String code) {
        ModelAndView mv = new ModelAndView();
        Role role = roleService.findRoleByNotPermission(code);
        mv.addObject("role", role);
        mv.setViewName("role-add-permission");
        return mv;
    }

    @RequestMapping(value = {"/addRoleAndPermission.do"}, method = RequestMethod.POST)
    public String addRoleAndPermission(
            @RequestParam(name = "code", required = true) String code,
            @RequestParam(name = "ids", required = true) String[] ids) {
        roleService.saveRoleAndPermissions(code, ids);
        return "forward:/role/roleList.do";
    }
}
