package com.mongo.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

@Document(collection = "account")
@Getter
@Setter
public class Account {
    @Id
    private String id;
    private String name;
    private String password;

    public Account(){}
    public Account(String id, String name, String password){
        this.id = id;
        this.name = name;
        this.password = password;
    }
}
