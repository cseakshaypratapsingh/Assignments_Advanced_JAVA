package com.springmvc.springmvcdemo.service;

import com.springmvc.springmvcdemo.dao.ProductDAO;
import com.springmvc.springmvcdemo.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductDAO productDAO;

    public ProductService(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    public List<Product> fetchProducts() {
        return productDAO.getAllProducts();
    }
}