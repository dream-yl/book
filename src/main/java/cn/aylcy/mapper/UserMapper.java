package cn.aylcy.mapper;

import cn.aylcy.entity.User;

/**
 * 用户持久层接口
 */
public interface UserMapper {

    /**
     * 注册
     * @param user
     * @return
     */
    Integer regUser(User user);

    /**
     * 通过用户名查找用户信息
     * @param username
     * @return
     */
    User findUserByUserName(String username);
}
