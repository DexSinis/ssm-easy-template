package com.github.ichenkaihua.service;

import com.github.ichenkaihua.mapper.UserMapper;
import com.github.ichenkaihua.model.User;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenkaihua on 15-9-15.
 */
@Service
public class UserService  {

    @Autowired
    UserMapper userMapper;



    @RequiresRoles("admin")
    public void deleteWithAdminRoleById(int id){
        userMapper.deleteByPrimaryKey(id);
    }


    public User getUserById(int id){
        return userMapper.selectByPrimaryKey(id);
    }



    public boolean isExist(User user){
        return  userMapper.selectCount(user)>0;
    }


    public void addUser(User user){
        userMapper.insert(user);
    }



    public List<User> getUsers2(User user){
        if (user == null) {
            return userMapper.selectAll();
        }

        return userMapper.select(user);
    }

    public List<User> getUsers(User user){
//        if (user == null) {
//            return userMapper.selectAll();
//        }
        System.out.println("--------------------开始查找全部users---------------------");
        List<User> list =  new ArrayList<User>();
        User user1 = userMapper.selectUserByID(2);
        System.out.println(user1+"------------------------user----------------");
        System.out.println(list +"------------------------list----------------");
        list.add(user1);
        System.out.println(list);
        return list;
    }


    public void deleteById(int id){
        userMapper.deleteByPrimaryKey(id);

    }

    public void update(User user){
        userMapper.updateByPrimaryKey(user);
    }


}
