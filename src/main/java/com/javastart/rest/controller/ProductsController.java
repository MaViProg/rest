package com.javastart.rest.controller;

import com.javastart.rest.entity.Product;
import com.javastart.rest.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/product")
public class ProductsController {

    private final ProductRepository productRepository;

    @Autowired
    public ProductsController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    @GetMapping
    public ResponseEntity<List<Product>> get() {
        return ResponseEntity.ok().body(productRepository.findAll());
    }

    @GetMapping("/{productId}")
    public ResponseEntity<Product> get(@PathVariable long productId) {
        return ResponseEntity.ok().body(productRepository
                .findById(productId)
                .orElseThrow(NoSuchElementException::new));
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody Product product) {
        productRepository.save(product);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{productId}")
    public ResponseEntity<Void> update(@RequestBody Product updatedProduct,
                                       @PathVariable long productId) {
        Product product = productRepository
                .findById(productId)
                .orElseThrow(NoSuchElementException::new);
        if (StringUtils.hasText(updatedProduct.getName()))
            product.setName(updatedProduct.getName());
        if (StringUtils.hasText(updatedProduct.getDescription()))
            product.setDescription(updatedProduct.getDescription());
        if (updatedProduct.getImplementationCost() != null)
            product.setImplementationCost(updatedProduct.getImplementationCost());
        productRepository.save(product);

        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<Void> delete(@PathVariable long productId) {
        productRepository.deleteById(productId);
        return ResponseEntity.ok().build();
    }


}
