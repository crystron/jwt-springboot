package com.mongo.repository;

import com.mongo.entity.Account;
import com.mongo.entity.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends MongoRepository<Account, String> {
    public List<Account> findAll();
}
