package com.vaibhav.productapp.controller;

import com.vaibhav.productapp.entity.Product;
import com.vaibhav.productapp.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    ProductService productService ;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/all")
    public List<Product> findAllProducts(){
       return productService.getAllProducts() ;
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id){
        return productService.getProductById(id) ;
    }

    @DeleteMapping("/delete/{id}")
    public void deleteProductById(@PathVariable Long id){
         productService.deleteById(id);
    }

    @PostMapping("/add")
    public Product saveProduct(@RequestBody Product product){
        return productService.saveProduct(product) ;
    }

    @PutMapping("/update/{id}")
    public Product updateProduct(@RequestBody Product product, @PathVariable Long id ){
        return productService.updateProduct(product ,id ) ;
    }
}
