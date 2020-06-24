package cn.aylcy.service.impl;

import cn.aylcy.entity.Order;
import cn.aylcy.entity.OrderItem;
import cn.aylcy.mapper.BookMapper;
import cn.aylcy.mapper.CartMapper;
import cn.aylcy.mapper.OrderMapper;
import cn.aylcy.service.OrderService;
import com.sun.org.apache.xpath.internal.operations.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

/**
 * 订单业务层实现类
 */
@Service
public class OrderServiceImpl implements OrderService {

    protected static final String SESSION_UID = "uid";
    protected static final String SESSION_USERNAME = "username";

    @Autowired
    OrderMapper orderMapper;
    @Autowired
    BookMapper bookMapper;
    @Autowired
    CartMapper cartMapper;

    @Transactional
    @Override
    public void addOrder(String purchaseName, String address, String phone, String eMail, List<Integer> cids, HttpSession session) {
        //创建订单实体
        Order order = new Order();
        order.setPurchaseName(purchaseName);
        order.setAddress(address);
        order.seteMail(eMail);
        order.setPhone(phone);
        order.setUid(getUidFromSession(session));
        order.setCreateTime(new Date().toString());
        //添加主体，返回oid
        orderMapper.addOrder(order);
        Integer oid = order.getOid();
        //循环添加cid对应的信息
        for (Integer integer: cids){
            OrderItem orderItem = new OrderItem();
            orderItem.setBid(cartMapper.findCartByCid(integer).getBid());
            orderItem.setCount(cartMapper.findCartByCid(integer).getCount());
            orderItem.setOid(oid);
            orderItem.setPrice(cartMapper.findCartByCid(integer).getUnitPrice());
            orderItem.setTitleName(bookMapper.findBookById(cartMapper.findCartByCid(integer).getBid()).getTitleName());
            orderMapper.addOrderItem(orderItem);
            //将添加到订单的购物车删除
            cartMapper.deleteByCid(integer);
        }
    }

    @Override
    public List<Order> findOrderAllByUid(HttpSession session) {
        Integer uid = getUidFromSession(session);
        List<Order> data = orderMapper.findOrderAllByUid(uid);
        for (Order order : data){
            order.setList(orderMapper.findOrderItemByOid(order.getOid()));
        }
        return data;
    }

    @Override
    public void deleteOrder(Integer oid) {
        orderMapper.deleteOrder(oid);
    }

    public String getUsernameFromSession(HttpSession session) {
        // 从sesn中获取username
        return session.getAttribute(SESSION_USERNAME).toString();
    }

    public Integer getUidFromSession(HttpSession session) {
        // 从session中获取uid
        return Integer.valueOf(session.getAttribute(SESSION_UID).toString());
    }

}
