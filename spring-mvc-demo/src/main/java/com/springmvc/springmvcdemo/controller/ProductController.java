package com.springmvc.springmvcdemo.controller;

import com.springmvc.springmvcdemo.model.Product;
import com.springmvc.springmvcdemo.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public String showProducts(Model model) {

        List<Product> productList = productService.fetchProducts();

        model.addAttribute("products", productList);

        return "products";
    }
}