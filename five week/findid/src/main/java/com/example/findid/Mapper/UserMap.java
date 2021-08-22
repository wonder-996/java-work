package com.example.findid.Mapper;

import com.example.findid.user.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMap {


  public   User getUserid(int id);
}
