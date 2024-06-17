package com.vaibhav.productapp.service;

import com.vaibhav.productapp.entity.Product;
import com.vaibhav.productapp.entity.User;
import com.vaibhav.productapp.repository.ProductRepo;
import com.vaibhav.productapp.repository.UserRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    UserRepo userRepo ;

    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public List<User> getAllUser(){
        return  userRepo.findAll();
    }

    public User getUserById(Long id){
        return userRepo.findById(id).orElse(null) ;
    }

    public void deleteUserById(Long id){
        userRepo.deleteById(id);
    }

    public User updateUser(User user , Long id){
        User p1 = userRepo.findById(id).orElse(null);
        if(p1!=null){
            p1.setName(user.getName());
        }
        return userRepo.save(p1) ;
    }

    public User saveUser(User user){
        return userRepo.save(user);
    }

}
