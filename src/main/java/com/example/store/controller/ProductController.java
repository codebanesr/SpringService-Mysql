package com.example.store.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.store.exception.ResourceNotFoundException;
import com.example.store.model.Product;
import com.example.store.repository.ProductRepository;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @PostMapping("/product")
    public Product createProduct(@Valid @RequestBody Product product) {
        return productRepository.save(product);
    }

    @GetMapping("/product/{id}")
    public Product getProductById(@PathVariable(value = "id") Long noteId) {
        return productRepository.findById(noteId)
                .orElseThrow(() -> new ResourceNotFoundException("Product", "id", noteId));
    }

    @PutMapping("/product/{id}")
    public Product updateProduct(@PathVariable(value = "id") Long noteId,
                                           @Valid @RequestBody Product noteDetails) {

        Product product = productRepository.findById(noteId)
                .orElseThrow(() -> new ResourceNotFoundException("Product", "id", noteId));

        product.setTitle(noteDetails.getTitle());
        product.setContent(noteDetails.getContent());

        Product updatedProduct = productRepository.save(product);
        return updatedProduct;
    }

    @DeleteMapping("/product/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable(value = "id") Long noteId) {
        Product product = productRepository.findById(noteId)
                .orElseThrow(() -> new ResourceNotFoundException("Product", "id", noteId));

        productRepository.delete(product);

        return ResponseEntity.ok().build();
    }
}


//Once we have mapping in place, next thing we want is to handle Exceptions, so we will write Resource not found exception class next
