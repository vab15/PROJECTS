package com.vaibhav.productapp.controller;

import com.vaibhav.productapp.entity.Product;
import com.vaibhav.productapp.entity.User;
import com.vaibhav.productapp.service.ProductService;
import com.vaibhav.productapp.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    UserService userService ;


    public UserController(UserService userService) {
        this.userService = userService;
    }



    @GetMapping("/all")
    public List<User> findAllProducts(){
        return userService.getAllUser() ;
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id){
        return userService.getUserById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUserById(@PathVariable Long id){
        userService.deleteUserById(id);
    }

    @PostMapping("/add")
    public User saveProduct(@RequestBody User user){
        return userService.saveUser(user) ;
    }

    @PutMapping("/update/{id}")
    public User updateUser(@RequestBody User user, @PathVariable Long id ){
        return userService.updateUser(user ,id ) ;

    }


    @GetMapping("/products/{id}")
    public ResponseEntity<List<Product>> getProductsByUserId(@PathVariable Long id){

        return new ResponseEntity<>(userService.getProductsByUserId(id), HttpStatus.OK) ;
    }
}
