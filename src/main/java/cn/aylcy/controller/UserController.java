package cn.aylcy.controller;

import cn.aylcy.entity.User;
import cn.aylcy.service.UserService;
import cn.aylcy.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * 用户控制层
 */
@Controller
@RequestMapping("user")
public class UserController extends BaseController {

    @Autowired
    UserService userService;

    /**
     * 注册
     *
     * @param user
     * @return
     */
    @RequestMapping("reg")
    @ResponseBody
    public JsonResult<Void> reg(User user) {
        JsonResult<Void> result = new JsonResult<>();
        userService.regUser(user);
        result.setState(SUCCESS);
        return result;
    }

    /**
     * 登陆
     *
     * @param user
     * @param session
     * @return
     */
    @RequestMapping("login")
    @ResponseBody
    public JsonResult<Void> login(User user, HttpSession session) {
        JsonResult<Void> result = new JsonResult<>();
        User queUser = userService.login(user);
        // 向session中添加uid
        session.setAttribute(SESSION_UID, queUser.getUid());
        // 向session中添加username
        session.setAttribute(SESSION_USERNAME, queUser.getUsername());
        result.setState(SUCCESS);
        return result;
    }


    /**
     * 获取当前登陆的信息
     *
     * @param session
     * @return
     */
    @RequestMapping("getLoginUser")
    @ResponseBody
    public JsonResult<String> getLoginUser(HttpSession session) {
        JsonResult<String> result = new JsonResult<>();
        String username = userService.getLoginUser(session);
        result.setState(SUCCESS);
        result.setData(username);
        return result;
    }
}
