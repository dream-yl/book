package cn.aylcy.mapper;

import cn.aylcy.entity.Order;
import cn.aylcy.entity.OrderItem;

import java.util.List;

/**
 * 订单持久层接口
 */
public interface OrderMapper {

    /**
     * 添加order
     * @return
     */
    Integer addOrder(Order order);

    /**
     * 删除
     * @return
     */
    Integer deleteOrder(Integer oid);

    /**
     * 添加orderitem
     * @return
     */
    Integer addOrderItem(OrderItem orderItem);

    /**
     * 通过uid获取所有的订单
     * @param uid
     * @return
     */
    List<Order> findOrderAllByUid(Integer uid);

    /**
     * 通过订单id获取所有的明细
     * @param oid
     * @return
     */
    List<OrderItem> findOrderItemByOid(Integer oid);
}
