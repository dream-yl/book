package cn.aylcy.mapper;

import cn.aylcy.entity.UserDemo;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 使用注解写sql的测试持久层
 */
public interface UserMapperDemo {
    String str = "SELECT * FROM tb_user";

    @Select(str)
    List<UserDemo> findAll();
}
