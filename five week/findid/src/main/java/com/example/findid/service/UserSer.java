package com.example.findid.service;

import com.example.findid.Mapper.UserMap;
import com.example.findid.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserSer{
    @Autowired
    private UserMap userMap;
    public User getUserid(int id){
        return userMap.getUserid(id);
    }
}
