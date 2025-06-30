package com.udea.graphqludea.controller;

import com.udea.graphqludea.entity.CustomResponseEntity;
import com.udea.graphqludea.entity.UserEntity;
import com.udea.graphqludea.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import java.util.List;

@Controller
public class UserController {

    private final IUserService userService;

    @Autowired
    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @QueryMapping
    public List<UserEntity> findAllUsers() {
        return userService.findAllUsers();
    }

    @QueryMapping
    public UserEntity findUserById(@Argument Long id) {
        return userService.findUserById(id);
    }

    @MutationMapping
    public UserEntity addUser(@Argument UserEntity user) {
        return userService.addUser(user);
    }

    @MutationMapping
    public CustomResponseEntity deleteUser(@Argument Long id){
        return userService.deleteUser(id);
    }

}
