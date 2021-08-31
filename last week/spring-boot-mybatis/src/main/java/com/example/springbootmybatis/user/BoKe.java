package com.example.springbootmybatis.user;

import lombok.Data;

@Data
public class BoKe {
    private int id;
    private String name;
    private String passage;

    public int getId() {
        return id;
    }
}
