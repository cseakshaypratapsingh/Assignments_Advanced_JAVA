package com.springmvc.springmvcdemo.dao;

import com.springmvc.springmvcdemo.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductDAO {

    public List<Product> getAllProducts() {

        List<Product> products = new ArrayList<>();

        products.add(new Product(1, "Laptop", 75000));
        products.add(new Product(2, "Mobile", 25000));
        products.add(new Product(3, "Headphones", 3000));

        return products;
    }
}