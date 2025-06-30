package com.udea.graphqludea.interfaces;

import com.udea.graphqludea.entity.CustomResponseEntity;
import com.udea.graphqludea.entity.UserEntity;

import java.util.List;

public interface IUserService {

    List<UserEntity> findAllUsers();
    UserEntity findUserById(Long id);
    UserEntity addUser(UserEntity user);
    UserEntity findUserByEmail(String email);
    CustomResponseEntity deleteUser(Long id);

}
