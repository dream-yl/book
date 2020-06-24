package cn.aylcy.controller;

import cn.aylcy.entity.CartVO;
import cn.aylcy.service.CartService;
import cn.aylcy.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 购物车控制层
 */
@Controller
@RequestMapping("cart")
public class CartController extends BaseController {

    @Autowired
    CartService cartService;

    /**
     * 添加
     *
     * @return
     */
    @RequestMapping("addCart")
    @ResponseBody
    public JsonResult<Void> addCart(Integer bid, Integer count, HttpSession session) {
        JsonResult<Void> result = new JsonResult<>();
        cartService.addCart(bid,count,session);
        result.setState(SUCCESS);
        return result;
    }

    /**
     * 查询当前登陆用户的所有信息（未删除的）
     *
     * @return
     */
    @RequestMapping("findCartAll")
    @ResponseBody
    public JsonResult<List<CartVO>> findCartAll(HttpSession session) {
        JsonResult<List<CartVO>> result = new JsonResult<>();
        List<CartVO> data = cartService.findCartAll(session);
        System.out.println(data.toString());
        result.setData(data);
        result.setState(SUCCESS);
        return result;
    }


    /**
     * 查询当前登陆用户的所有信息（未删除的）（管理员专用）
     *
     * @return
     */
    @RequestMapping("findCartAllByRoot")
    @ResponseBody
    public JsonResult<List<CartVO>> findCartAllByRoot() {
        JsonResult<List<CartVO>> result = new JsonResult<>();
        List<CartVO> data = cartService.findCartAllByRoot();
        System.out.println(data.toString());
        result.setData(data);
        result.setState(SUCCESS);
        return result;
    }


    /**
     * 通过cid删除当前信息
     *
     * @return
     */
    @RequestMapping("deleteByCid")
    @ResponseBody
    public JsonResult<Void> deleteByCid(Integer cid) {
        JsonResult<Void> result = new JsonResult<>();
        cartService.deleteByCid(cid);
        result.setState(SUCCESS);
        return result;
    }
}
