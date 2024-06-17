package com.vaibhav.productapp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id ;
    private String name ;
    private Long price ;


    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Long getPrice() {
        return price;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }


}
