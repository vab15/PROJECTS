package com.vaibhav.productapp.service;

import com.vaibhav.productapp.entity.Product;
import com.vaibhav.productapp.repository.ProductRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    ProductRepo productRepo ;

    public ProductService(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    public List<Product> getAllProducts(){
      return  productRepo.findAll();
    }

    public Product getProductById(Long id){
        return productRepo.findById(id).orElse(null) ;
    }

    public void deleteById(Long id){
        productRepo.deleteById(id);
    }

    public Product updateProduct(Product product , Long id){
     Product p1 = productRepo.findById(id).orElse(null);
     if(p1!=null){
         p1.setName(product.getName());
         p1.setPrice(product.getPrice());
     }
     return productRepo.save(p1) ;
    }

    public Product saveProduct(Product product){
         return productRepo.save(product);
    }

}
