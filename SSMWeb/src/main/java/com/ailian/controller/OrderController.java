package com.ailian.controller;

import com.ailian.bean.Order;
import com.ailian.service.IOrderService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(value = {"/order"})
public class OrderController {

    @Autowired
    private IOrderService orderService;

    @RequestMapping(value = {"/orderList.do"})
    public ModelAndView findAll() {
        ModelAndView mv = new ModelAndView();
        List<Order> orders = orderService.findOrderAndProduct();
        mv.addObject("list", orders);
        mv.setViewName("orderList");
        return mv;
    }

    @RequestMapping(value = {"/orderList_page.do"})
    public ModelAndView findAll(
            @RequestParam(name = "page", required = true, defaultValue = "1") Integer page,
            @RequestParam(name = "pageSize", required = true, defaultValue = "10") Integer pageSize ) {
        ModelAndView mv = new ModelAndView();
        List<Order> orders = orderService.findOrderAndProduct(page, pageSize);
        PageInfo pageInfo = new PageInfo(orders);
        mv.addObject("pageInfo", pageInfo);
        mv.setViewName("order-list");
        return mv;
    }

    @RequestMapping("/order_show.do")
    public ModelAndView order_show(@RequestParam(name="code") String code) {
        ModelAndView mv = new ModelAndView();
        if (code != null) {
            Order order = orderService.findOrderByCode(code);
            mv.addObject("order", order);
        }
        mv.setViewName("order-show");
        return mv;
    }
}
