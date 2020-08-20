package com.mongo.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "product")
@Getter
@Setter
public class Product {
    @Id
    private String id;
    private String name;
    private String image;

    public Product() {}
    public Product(String name, String image){
        this.name = name;
        this.image = image;
    }
    public Product(String id, String name, String image){
        this(name,image);
        this.id = id;
    }
    @Override
    public String toString(){
        return String.format("Product[id=%s, name='%s',image='%s']",id, name, image);
    }
}
