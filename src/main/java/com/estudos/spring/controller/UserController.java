package com.estudos.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estudos.spring.db.UserDB;
import com.estudos.spring.model.User;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserDB user;

    @GetMapping
    public List<User> listAll() {
        return user.findAll();
    }

    @GetMapping("{id}")
    public User getUser(@PathVariable Long id) {
        return user.findById(id).get();
    }

    @PostMapping
    public User store(@RequestBody User newUser) {
        return user.save(newUser);
    }

    @PutMapping
    public User update(@RequestBody User updateUser) {
        if (updateUser.getId() > 0)
            return user.save(updateUser);
        return null;
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        user.deleteById(id);
    }

}
