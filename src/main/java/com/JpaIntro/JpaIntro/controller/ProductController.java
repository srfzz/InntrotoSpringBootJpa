package com.JpaIntro.JpaIntro.controller;


import com.JpaIntro.JpaIntro.entities.ProductEntity;
import com.JpaIntro.JpaIntro.repository.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {
    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    @GetMapping("/products")
    public List<ProductEntity> findAll(@RequestParam(defaultValue = "id") String[] sortBy, @RequestParam(defaultValue = "1") int pageNumber){
//        return productRepository.findBy(Sort.by(sortBy));
        int size = 5;
        Pageable pageable= PageRequest.of( pageNumber,size,Sort.by(Sort.Direction.DESC,(sortBy)));
        return  productRepository.findAll(pageable).getContent();
    }
}
