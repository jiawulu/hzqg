package com.lu.test;

import com.lu.dao.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @RequestMapping("/product")
    public String greeting() {

        System.out.println(productRepository);

        productRepository.findAll();

        return "123";

    }


}
