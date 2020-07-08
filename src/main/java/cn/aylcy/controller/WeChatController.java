package cn.aylcy.controller;

import cn.aylcy.mapper.UserMapperDemo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import java.util.logging.Logger;

/**
 *
 */
@Controller
@RequestMapping("test")
public class WeChatController {
    @Autowired
    private UserMapperDemo userMapperDemo;

    Logger log = Logger.getLogger(String.valueOf(WeChatController.class));

    @RequestMapping("getMap")
    @ResponseBody
    public Map<String, List<Integer>> getOpenid(){
        Map<String, List<Integer>> map = new HashMap<String, List<Integer>>();
        log.info("kaishi");
        log.info(userMapperDemo.findAll().toString());
        //已经申请过模拟
        return map;
    }
}
