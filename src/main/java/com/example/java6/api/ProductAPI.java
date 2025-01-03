package com.example.java6.api;

import com.example.java6.entity.Product;
import com.example.java6.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/products")
public class ProductAPI {
    @Autowired
    ProductService productService;

    //    @GetMapping("{id}")
//    public Product getProduct(@PathVariable("id") Integer id) {
//        return productService.findById(id);
//    }
    @GetMapping()
    public List<Product> getAll() {
        return productService.findAll();
    }

    @GetMapping("{id}")
    public Product getOne(@PathVariable("id") Integer id) {
        return productService.findById(id);
    }

    @PostMapping
    public Product create(@RequestBody Product product) {
        return productService.create(product);
    }

    @PutMapping("{id}")
    public Product update(@PathVariable("id") Integer id, @RequestBody Product product) {
        return productService.update(product);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Integer id) {
        productService.delete(id);
    }
}
