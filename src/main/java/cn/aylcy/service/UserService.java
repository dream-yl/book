package cn.aylcy.service;

import cn.aylcy.entity.User;

import javax.servlet.http.HttpSession;

/**
 * 用户业务层接口
 */
public interface UserService {

    /**
     * 用户注册
     * @param user
     */
    void regUser(User user);

    /**
     * 用户登陆
     * @param user
     */
    User login(User user);

    /**
     * 获取用户的登陆信息
     * @param session
     * @return
     */
    String getLoginUser(HttpSession session);
}
