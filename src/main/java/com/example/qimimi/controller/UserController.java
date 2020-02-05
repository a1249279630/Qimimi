package com.example.qimimi.controller;

import com.example.qimimi.pojo.User;
import com.example.qimimi.request.AddUserRequest;
import com.example.qimimi.request.UpdateUserRequest;
import com.example.qimimi.service.UserService;
import com.example.qimimi.utils.IsEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
private UserService userService;

    @PostMapping (value = "Register/User")
    public String RegisterUser(@RequestBody AddUserRequest addUserRequest,String random){
        IsEmail isEmail=new IsEmail();
        if(isEmail.isEmail(addUserRequest.getEmail())){
            Integer integer = userService.RegisterUser(addUserRequest,random);
            if(integer==1){
                return "注册成功,请在邮箱查看激活码";
            }else if(integer==-1){
                return "注册失败，用户名已被占用，请重新输入";
            }else if(integer==0) {
                return "请输入激活码";
            }else if(integer==-2) {
                return "注册失败，激活码不对";
            }else {
                    return "注册失败，未知错误";
                }
        }else{
            return "注册失败，邮箱格式错误";
        }
    }

    @DeleteMapping(value = "Delete/User/By/Nike_Name")
    public String DeleteUserByNikeName(@RequestBody String nikeName){
        Integer integer = userService.DeleteUserByNikeName(nikeName);
        if(integer==1){
            return "删除成功";
        }else {
            return "用户名不存在";
        }
    }

    @PostMapping(value = "LoginUser/By/Nike_NameAndPassword")
    public String LoginUser(String username,String password){
        User user = userService.LoginUser(username, password);
        if(user==null||user.equals("")){
            return "用户名或密码错误";
        }else {
            return ""+user.toString();
        }
    }

    @PostMapping(value = "UpdateUser/By/Nike_Name")
    public Integer UpdateUserByNickName(@RequestBody UpdateUserRequest updateUserRequest,String nikename){
        return userService.UpdateUserByNickName(updateUserRequest,nikename);
        }
}
