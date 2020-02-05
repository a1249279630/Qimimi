package com.example.qimimi.service.Impl;

import com.example.qimimi.dao.UserDao;
import com.example.qimimi.pojo.User;
import com.example.qimimi.request.AddUserRequest;
import com.example.qimimi.request.UpdateUserRequest;
import com.example.qimimi.service.UserService;
import com.example.qimimi.utils.MailUtil;
import com.example.qimimi.utils.RandomCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    private String randomtemp="";
    @Override
    public Integer RegisterUser(AddUserRequest aur,String random) {
        try {
            if(random==null||random.equals("")){
                randomtemp=RandomCode.RandomSafetyCode();
                MailUtil.sendEmail(aur.getEmail(), aur.getNickName()+randomtemp);
                return 0;
            }else {
                if(!random.equals(randomtemp)){
                    return -2;
                }
            }
                List<User> userByNickName = userDao.findUserByNickName(aur.getNickName());
                if(CollectionUtils.isEmpty(userByNickName)){
                    User user=new User();
                    user.setDepartment(aur.getDepartment());
                    user.setEmail(aur.getEmail());
                    user.setFaculty(aur.getFaculty());
                    user.setNickName(aur.getNickName());
                    user.setPassword(aur.getPassword());
                    user.setSex(aur.getSex());
                    user.setSchool(aur.getSchool());
                    user.setPhone(aur.getPhone());
                    user.setName(aur.getName());
                    user.setCreatTime(new Date());
                    user.setRandomCode(random);

                    userDao.AddUser(user);
                    randomtemp="";
                    return  1;
                }else {
                    return -1;
                }
        }
        catch (Exception e){
                return -3;
        }
    }

    @Override
    public Integer DeleteUserByNikeName(String nikeName) {
        List<User> userByNickName = userDao.findUserByNickName(nikeName);
        if(CollectionUtils.isEmpty(userByNickName)){
            return -1;
        }else {
            return userDao.DeleteUserByNikeName(nikeName);
        }
    }

    @Override
    public User LoginUser(String username, String password) {
        return userDao.LoginUser(username, password);
    }

    @Override
    public Integer UpdateUserByNickName(UpdateUserRequest uur,String nikename) {
        List<User> userByNickName = userDao.findUserByNickName(nikename);
        User user = userByNickName.get(0);
        user.setPhone(uur.getPhone());
        user.setEmail(uur.getEmail());
        return userDao.UpdateUserById(user);
    }


}






