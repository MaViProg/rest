package com.javastart.rest.entity;

import javax.persistence.*;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="product_id")
    private long productId;

    private String name;

    private String description;

    private Integer implementationCost;


    public void setProductId(long productId) {
        this.productId = productId;
    }

    public long getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getImplementationCost() {
        return implementationCost;
    }

    public void setImplementationCost(Integer implementationCost) {
        this.implementationCost = implementationCost;
    }


}
