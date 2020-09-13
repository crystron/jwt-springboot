package com.mongo.controller;

import com.mongo.entity.Account;
import com.mongo.entity.Product;
import com.mongo.repository.AccountRepository;
import com.mongo.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class AccountController {
    @Autowired
    AccountRepository repository;
    @GetMapping("/getAllAcc")
    public List<Account> getAll(){
        return repository.findAll();
    }
    @PostMapping("/saveAcc")
    public Account insertAccount(@RequestBody Account account){
        repository.insert(new Account(
                account.getId(),
                account.getName(),
                account.getPassword()
        ));
        return account;
    }

    @DeleteMapping("/deleteAcc/{id}")
    public String deleteAccount(@PathVariable String id){
        repository.deleteAccountById(id);
        return "deleted" + id;
    }
}
