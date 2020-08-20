package com.mongo;

import com.mongo.entity.Account;
import com.mongo.entity.Product;
import com.mongo.repository.AccountRepository;
import com.mongo.repository.ProductRepository;
import com.mongo.service.AccountService;
import com.mongo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import javax.management.Query;
import java.net.PortUnreachableException;
import java.util.Optional;

@SpringBootApplication
public class WebApplication implements CommandLineRunner{
    @Autowired
    AccountRepository repository;
    @Autowired
    public static void main(String[] args) {
        SpringApplication.run(WebApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println(repository.findAll());
    }
}
