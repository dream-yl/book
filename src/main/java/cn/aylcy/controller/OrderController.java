package cn.aylcy.controller;

import cn.aylcy.entity.Order;
import cn.aylcy.service.OrderService;
import cn.aylcy.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 订单控制层
 */
@Controller
@RequestMapping("order")
public class OrderController extends BaseController {

    @Autowired
    OrderService orderService;

    /**
     * 添加
     * @return
     */
    @RequestMapping("addOrder")
    @ResponseBody
    public JsonResult<Void> addOrder(String purchaseName, String address,
                                     String phone, String eMail,
                                     @RequestParam("cids") List<Integer> cids,
                                     HttpSession session) {
        JsonResult<Void> result = new JsonResult<>();
        orderService.addOrder(purchaseName,address,phone,eMail,cids,session);
        result.setState(SUCCESS);
        return result;
    }

    /**
     * 查询
     * @return
     */
    @RequestMapping("findOrderAllByUid")
    @ResponseBody
    public JsonResult<List<Order>> findOrderAllByUid(HttpSession session) {
        JsonResult<List<Order>> result = new JsonResult<>();
        List<Order> data = orderService.findOrderAllByUid(session);
        result.setData(data);
        result.setState(SUCCESS);
        return result;
    }


    /**
     * 删除
     * @return
     */
    @RequestMapping("deleteOrder")
    @ResponseBody
    public JsonResult<Void> deleteOrder(Integer oid) {
        JsonResult<Void> result = new JsonResult<>();
        orderService.deleteOrder(oid);
        result.setState(SUCCESS);
        return result;
    }
}
