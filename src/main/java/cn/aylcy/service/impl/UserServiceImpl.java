package cn.aylcy.service.impl;

import cn.aylcy.entity.User;
import cn.aylcy.mapper.UserMapper;
import cn.aylcy.service.UserService;
import cn.aylcy.service.ex.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

/**
 * 用户业务层实现类
 */
@Service
public class UserServiceImpl implements UserService {

    protected static final String SESSION_UID = "uid";
    protected static final String SESSION_USERNAME = "username";

    @Autowired
    UserMapper userMapper;

    @Override
    public void regUser(User user) {

        if("".equals(user.getUsername()) || "".equals(user.getPassword())){
            throw new UserNotFoundException("请填写完整注册信息！");
        }

        User checkUser = userMapper.findUserByUserName(user.getUsername());
        if(checkUser !=null ){
            throw new UserNotFoundException("该用户名已经注册！");
        }
        userMapper.regUser(user);
    }

    @Override
    public User login(User user) {
        User checkUser = userMapper.findUserByUserName(user.getUsername());
        if(checkUser ==null ){
            throw new UserNotFoundException("该用户名不存在！");
        }
        if(!checkUser.getPassword().equals(user.getPassword())){
            throw new UserNotFoundException("密码错误！");
        }
        return checkUser;
    }

    @Override
    public String getLoginUser(HttpSession session) {
        //获取session中的username
        Object object = session.getAttribute(SESSION_USERNAME);
        //为空，未登陆，返回空字符串
            if(object == null ){
                return "";
            }else{
        //已登陆，返回用户名
                return object.toString();
            }
    }






    public String getUsernameFromSession(HttpSession session) {
        // 从session中获取username
        return session.getAttribute(SESSION_USERNAME).toString();
    }

    public Integer getUidFromSession(HttpSession session) {
        // 从session中获取uid
        return Integer.valueOf(session.getAttribute(SESSION_UID).toString());
    }
}
