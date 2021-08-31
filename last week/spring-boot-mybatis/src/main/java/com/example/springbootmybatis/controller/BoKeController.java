package com.example.springbootmybatis.controller;

import com.example.springbootmybatis.service.BoKeService;
import com.example.springbootmybatis.user.BoKe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class BoKeController {
    @Autowired
    BoKeService boKeService;
    @ResponseBody
    @GetMapping("/BoKe")
public BoKe getBoKeById(@RequestParam("id") int id){
        return boKeService.getById(id);
    }
    @ResponseBody
    @GetMapping("/BoKeAll")
    public List<BoKe> getBoKeAll(){
        return boKeService.getAll();
    }
    @ResponseBody
    @GetMapping("/BoKeAdd")
    public BoKe BoKeinsert(BoKe boKe){
      return  boKeService.insertOne(boKe);
    }
    @ResponseBody
    @GetMapping("/BoKeDelete")
    public List<BoKe> BoKeDelete(int id){
        if(boKeService.deleteOne(id)>=1){System.out.println("id为"+id+"的博客删除成功");
        return boKeService.getAll();}
        else {System.out.println("删除失败");
            return null;}
    }
    @ResponseBody
    @GetMapping("/BoKeUpdate")
    public List<BoKe> update(BoKe boKe)
    {
        if (boKeService.updateOne(boKe)>=1){System.out.println("id为"+boKe.getId()+"的博客修改成功");
        return boKeService.getAll();}
        else return null;
    }
}
