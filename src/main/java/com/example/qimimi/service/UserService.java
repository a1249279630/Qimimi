package com.example.qimimi.service;

import com.example.qimimi.pojo.User;
import com.example.qimimi.request.AddUserRequest;
import com.example.qimimi.request.UpdateUserRequest;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    Integer RegisterUser(AddUserRequest addUserRequest,String random);

    Integer DeleteUserByNikeName(String nikeName);

    User LoginUser(String username, String password);

    Integer UpdateUserByNickName(UpdateUserRequest updateUserRequest,String nikename);

//    Integer UpdateRandomCode(String randomCode);
}
