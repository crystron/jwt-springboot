package com.mongo.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.Id;

@Document(collection = "account")
@Getter
@Setter
public class Account {
    @Id
    private String id;
    @Field(name = "username")
    private String username;
    private String password;

    public Account(){}
    public Account(String id, String name, String password){
        this.id = id;
        this.username = name;
        this.password = password;
    }
}
