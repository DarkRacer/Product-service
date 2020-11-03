package ru.neoflex.ec.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.neoflex.ec.project.entity.ProductEntity;
import ru.neoflex.ec.project.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping("/available")
    @ResponseStatus(HttpStatus.OK)
    public List<ProductEntity> findByAvailable() {
        return productService.findByAvailable();
    }

    @GetMapping("/count/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<ProductEntity> findByCount(@PathVariable Long id) {
        return productService.findByCount(id);
    }
}
