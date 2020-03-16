package com.ailian.service.impl;

import com.ailian.bean.Product;
import com.ailian.dao.IProductDao;
import com.ailian.service.IProductService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.util.List;

@Service
@Transactional
public class ProductServiceImpl implements IProductService {

    @Autowired
    private IProductDao productDao;

    public void addProduct(Product product) throws ParseException {
        productDao.addProduct(product);
    }

    public List<Product> findAll() {
        return productDao.findAll();
    }

    public void updateProduct(Product product) {
        productDao.updateProduct(product);
    }

    public List<Product> findAll(int page, int pageSize) {
        PageHelper.startPage(page, pageSize);
        return productDao.findAll();
    }

    public Product findProductByCode(String code) {
        return productDao.findProductByCode(code);
    }
}
