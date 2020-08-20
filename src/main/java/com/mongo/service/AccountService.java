package com.mongo.service;

import com.mongo.entity.Account;
import com.mongo.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {
    @Autowired
    AccountRepository repository;
    public List<Account> getAll(){
        return repository.findAll();
    }
}
