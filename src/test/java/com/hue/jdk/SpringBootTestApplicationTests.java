package com.hue.jdk;

import com.hue.jdk.bean.User;
import com.hue.jdk.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
//打印日志
@Slf4j
@SpringBootTest
class SpringBootTestApplicationTests {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    DataSource dataSource;

    @Autowired
    UserMapper userMapper;

    @Test
    void contextLoads() {
        Long aLong = jdbcTemplate.queryForObject(
                "select count(*) from book", Long.class);

      //  List<User> maps = jdbcTemplate.queryForList("select  * from book", User.class);

        log.info("记录总数:{}"+aLong);

        log.info("数据源类型:{}"+dataSource.getClass());
    }

    @Test
     public  void testUserMapper()
     {
          User user = userMapper.selectById(1L);
          log.info("用户信息"+user);
     }

}
