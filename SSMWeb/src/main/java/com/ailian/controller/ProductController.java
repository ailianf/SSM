package com.ailian.controller;


import com.ailian.bean.Product;
import com.ailian.service.IProductService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.text.ParseException;
import java.util.List;

@Controller
@RequestMapping(value = "/product")
public class ProductController {

    @Autowired
    private IProductService productService;

    @RequestMapping(value = "productList_page.do")
    public ModelAndView productList(
            @RequestParam(name = "page", required = true, defaultValue = "1") Integer page,
            @RequestParam(name = "pageSize", required = true, defaultValue = "4") Integer pageSize
    ) {
        ModelAndView mv = new ModelAndView();
        List<Product> products = productService.findAll(page, pageSize);
        PageInfo pageInfo = new PageInfo(products);
        mv.addObject("pageInfo", pageInfo);
        mv.setViewName("product-list");
        return mv;
    }

    @RequestMapping(value = {"/addProduct.do"}, method = RequestMethod.GET)
    public ModelAndView addProduct() throws ParseException {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("product-add");
        return mv;
    }

    @RequestMapping(value = {"/addProduct.do"}, method = RequestMethod.POST)
    public String saveProduct(Product product) throws ParseException {
        productService.addProduct(product);
        return "forward:/product/productList_page.do";
    }

    @RequestMapping(value = {"/updateProduct.do"}, method = RequestMethod.GET)
    public ModelAndView updateProduct(
            @RequestParam(name = "page") Integer page,
            @RequestParam(name = "pageSize") Integer pageSize,
            @RequestParam(name = "code") String code) throws ParseException {
        ModelAndView mv  = new ModelAndView();
        Product product = productService.findProductByCode(code);
        mv.addObject("product", product);
        mv.addObject("page", page);
        mv.addObject("pageSize", pageSize);
        mv.setViewName("product-update");
        return mv;
    }

    @RequestMapping(value = {"/updateProduct.do"}, method = RequestMethod.POST)
    public String updateProduct(
            @RequestParam(name = "page") Integer page,
            @RequestParam(name = "pageSize") Integer pageSize,
            Product product) throws ParseException {
        System.out.println(product);
        productService.updateProduct(product);
        return "forward:/product/productList_page.do?page=" + page + "&&pageSize=" + pageSize;
    }


    @RequestMapping(value = "productList.do")
    public ModelAndView productList() {
        ModelAndView mv = new ModelAndView();
        List<Product> products = productService.findAll();
        mv.addObject("list", products);
        mv.setViewName("productList");
        return mv;
    }

}
