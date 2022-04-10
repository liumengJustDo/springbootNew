package com.hue.jdk.mapper;

import com.hue.jdk.bean.City;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @Classname CityMapper
 * @Description TODO
 * @Date 2022/4/7 15:45
 * @Created by liumeng
 */
@Mapper
@Repository
public interface CityMapper {

    @Select("select * from  city where  id=#{id}")
    public City getById(Long id);

//    加入option属性 使得主键`id` 自增
    @Insert("insert into  city(`name`,`state`,`country`) values(#{name},#{state},#{country})")
    @Options(useGeneratedKeys = true,keyProperty = "id")
    public void insert(City city);

}
