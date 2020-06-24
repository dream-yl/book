package cn.aylcy.service;

import cn.aylcy.entity.Order;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 订单业务层接口
 */
public interface OrderService {

    /**
     * 添加
     * @param purchaseName 姓名
     * @param address 地址
     * @param phone 电话
     * @param eMail 电子邮箱
     * @param cids 购物车集合
     * @param session
     */
   void addOrder(String purchaseName, String address,
                 String phone, String eMail, List<Integer> cids, HttpSession session);

    /**
     * 根据uid查询自己的订单
     * @param session
     * @return
     */
   List<Order> findOrderAllByUid(HttpSession session);

    /**
     * 根据oid删除订单
     * @param oid
     */
   void deleteOrder(Integer oid);
}
