package com.example.springbootmybatis.mapper;

import com.example.springbootmybatis.user.BoKe;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BoKeMapper {
    @Select("select * from boke_system.table2")
    public List<BoKe> getAll();
    @Select("select * from boke_system.table2 where id=#{id}")
    public BoKe getbyid(int id);
    @Insert("insert into table2(`id`,`name`,`passage`) values (#{id},#{name},#{passage})")
    @Options(useGeneratedKeys = true,keyProperty = "id")
    public int insert(BoKe boKe);
    @Delete("delete from boke_system.table2 where id=#{id}")
    public int delete(int id);
    @Update("update table2 set name=#{name},passage=#{passage} where id=#{id}")
    public int update(BoKe boKe);
}
