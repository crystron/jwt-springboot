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
    private String displayName;
    private String password;
    private boolean type;
}
