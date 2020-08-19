package com.mongo.service;

import com.mongo.entity.Product;
import com.mongo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;

    public List<Product> getProducts(){
        return repository.findAll();
    }


    public Product getOne(int id){
        return repository.findById(id);
    }

    public Product save(@RequestBody Product product){
        return repository.insert(product);
    }

    public void delete(int id){
        repository.deleteById(id);
    }
}
