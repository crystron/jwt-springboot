package com.mongo.controller;

import com.mongo.entity.Product;
import com.mongo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.mongo.repository.ProductRepository;


import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class ProductController {
    @Autowired
    ProductRepository repository;
    @Autowired
    private ProductService productSer;

    @GetMapping("/")
    public String homePage(){
        return "Home Page";
    }

    @GetMapping("/all")
    public List<Product> findAll(){
        return productSer.getProducts();
    }

    @GetMapping("/product/{id}")
    public Product findOne(@PathVariable("id")int id){
        return productSer.getOne(id);
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable("id") int id){
        productSer.delete(id);
        return "OK";
    }

    @PostMapping("/save")
    public String insertProduct(@RequestBody Product product ){
        repository.insert(new Product(
                            product.getId(),
                            product.getTitle(),
                            product.getAltName(),
                            product.getType(),
                            product.getImage(),
                            product.getStatus()
                        ));
        return "OK";
    }

    @PutMapping("/update/{id}")
    public String updateProduct(@RequestBody Product product, @PathVariable("id")String id){
        Optional<Product> p1 =  repository.findById(id);
        if ( p1.isPresent()){
            repository.save(new Product(
                    product.getId(),
                    product.getTitle(),
                    product.getImage(),
                    product.getAltName(),
                    product.getType(),
                    product.getStatus()
                    ));
            return "OK";
        }
        else
        {
            return "Error";
        }
    }
}
