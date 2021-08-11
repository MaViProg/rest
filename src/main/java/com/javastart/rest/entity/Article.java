package com.javastart.rest.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long articleId;

    @ManyToOne
    @JoinColumn(name="product_id")
    private Product product;

    private String name;

    private String content;

    private LocalDate creationDate;

    public void setArticleId(long articleId) {
        this.articleId = articleId;
    }


    public long getArticleId() {
        return articleId;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }
}
