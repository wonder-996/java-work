package com.example.springbootmybatis.service;

import com.example.springbootmybatis.mapper.BoKeMapper;
import com.example.springbootmybatis.user.BoKe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoKeService {
    @Autowired
    BoKeMapper boKeMapper;
    public BoKe getById(int id){
        return boKeMapper.getbyid(id);
    }
    public List<BoKe> getAll(){
        return boKeMapper.getAll();
    }
    public BoKe insertOne(BoKe boKe){
        int insert=boKeMapper.insert(boKe);
return boKe;
    }
    public int deleteOne(int id){
        return boKeMapper.delete(id);
    }
    public int updateOne(BoKe boKe){
        return boKeMapper.update(boKe);
    }
}
