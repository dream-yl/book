package cn.aylcy.service.impl;

import cn.aylcy.entity.Cart;
import cn.aylcy.entity.CartVO;
import cn.aylcy.mapper.CartMapper;
import cn.aylcy.service.CartService;
import cn.aylcy.service.ex.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 购物车业务层实现类
 */
@Service
public class CartServiceImpl implements CartService {

    protected static final String SESSION_UID = "uid";
    protected static final String SESSION_USERNAME = "username";

    @Autowired
    CartMapper cartMapper;


    @Override
    public void addCart(Integer bid, Integer count, HttpSession session) {
        //获取session中的uid
        Object object = session.getAttribute(SESSION_UID);
        //为空，未登陆，返回空字符串
        if (object == null) {
            throw new UserNotFoundException("当前未登录，请先登陆！");
        } else {
            Cart cart = new Cart();
            cart.setUid(Integer.valueOf(object.toString()));
            cart.setBid(bid);
            cart.setCount(count);
            cartMapper.addCart(cart);
        }
    }

    @Override
    public List<CartVO> findCartAll(HttpSession session) {
        //获取session中的uid
        Object object = session.getAttribute(SESSION_UID);
        //为空，未登陆，返回空字符串
        if (object == null) {
            throw new UserNotFoundException("当前未登录，请先登陆！");
        } else {
            Integer uid = Integer.valueOf(object.toString());
            return cartMapper.findCartAll(uid);
        }
    }

    @Override
    public List<CartVO> findCartAllByRoot() {
        return cartMapper.findCartAllByRoot();
    }

    @Override
    public void deleteByCid(Integer cid) {
        cartMapper.deleteByCid(cid);
    }
}
