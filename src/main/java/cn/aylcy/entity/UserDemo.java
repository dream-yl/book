package cn.aylcy.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 使用@Data注解代替getset方法的实体类测试
 */
@Data
public class UserDemo implements Serializable {
    private Integer uid;//
    private String  username;//用户名
    private String  password;//密码
    private Integer isRoot;//是否管理员
}
