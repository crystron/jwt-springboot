package com.mongo.entity;

import lombok.Generated;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Document(collection = "product")
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

    public String  getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }
}
