package com.ailian.controller;

import com.ailian.bean.Permission;
import com.ailian.service.IPermissionService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/permission")
public class PermissionController {

    @Autowired
    private IPermissionService permissionService;

    @RequestMapping(value = {"/addPermission.do"}, method = RequestMethod.GET)
    public ModelAndView addPermission() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("permission-add");
        return mv;
    }

    @RequestMapping(value = {"/addPermission.do"}, method = RequestMethod.POST)
    public String addPermission(Permission permission) {
        System.out.println(permission);
        permissionService.savePermission(permission);
        return "forward:/permission/findAll.do";
    }

    @RequestMapping("/findAll.do")
    public ModelAndView findAll(
            @RequestParam(name = "page", required = true, defaultValue = "1") Integer page,
            @RequestParam(name = "pageSize", required = true, defaultValue = "4") Integer pageSize) {
        ModelAndView mv = new ModelAndView();
        List<Permission> permissions = permissionService.findAll(page, pageSize);
        PageInfo pageInfo = new PageInfo(permissions);
        mv.addObject("pageInfo", pageInfo);
        mv.setViewName("permission-list");
        return mv;
    }
}
