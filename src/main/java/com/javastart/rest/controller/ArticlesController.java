package com.javastart.rest.controller;

import com.javastart.rest.entity.Article;
import com.javastart.rest.entity.Product;
import com.javastart.rest.repository.ArticleRepository;
import com.javastart.rest.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/article")
public class ArticlesController {

    private final ProductRepository productRepository;

    private final ArticleRepository articleRepository;

    @Autowired
    public ArticlesController(ProductRepository productRepository, ArticleRepository articleRepository) {
        this.productRepository = productRepository;
        this.articleRepository = articleRepository;
    }

    @GetMapping
    public ResponseEntity<List<Article>> get() {
        return ResponseEntity.ok().body(articleRepository.findAll());
    }

    @GetMapping("/{articleId}")
    public ResponseEntity<Article> get(@PathVariable long articleId) {
        return ResponseEntity.ok().body(articleRepository
                .findById(articleId)
                .orElseThrow(NoSuchElementException::new));
    }


    @PostMapping
    public ResponseEntity<Void> create(@RequestBody Article article, @RequestParam long productId) {
        Product product = productRepository.findById(productId).orElseThrow(NoSuchElementException::new);
        article.setProduct(product);
        article.setCreationDate(LocalDate.now());
        articleRepository.save(article);

        return ResponseEntity.ok().build();
    }

    @PutMapping("/{articleId}")
    public ResponseEntity<Void> update(@RequestBody Article updatedArticle,
                                       @PathVariable long articleId) {
        Article article = articleRepository
                .findById(articleId)
                .orElseThrow(NoSuchElementException::new);
        if (StringUtils.hasText(updatedArticle.getName()))
            article.setName(updatedArticle.getName());
        if (StringUtils.hasText(updatedArticle.getContent()))
            article.setContent(updatedArticle.getContent());


        articleRepository.save(article);

        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{articleId}")
    public ResponseEntity<Void> delete(@PathVariable long articleId) {
        articleRepository.deleteById(articleId);
        return ResponseEntity.ok().build();
    }
}
