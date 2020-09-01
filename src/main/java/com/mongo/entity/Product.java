package com.mongo.entity;

import com.sun.xml.internal.ws.util.UtilException;
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
    private String title;
    private String altName;
    private String image;
    private String type;
    private Boolean status;

    public Product() {}
    public Product(String id, String title, String altName, String type, String image, Boolean status){
        this.id = id;
        this.title = title;
        this.altName = altName;
        this.type = type;
        this.image = image;
        this.status = status;
    }
    @Override
    public String toString(){
        return String.format("Product[id=%s, name='%s',image='%s']",id, title, image);
    }

}
