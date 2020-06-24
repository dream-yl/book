package cn.aylcy.service;

import cn.aylcy.entity.CartVO;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 购物车业务层接口
 */
public interface CartService {
    /**
     * 添加
     * @return
     */
    void addCart(Integer bid, Integer count, HttpSession session);

    /**
     * 查询当前登陆用户的所有信息（未删除的）
     * @param session
     * @return
     */
    List<CartVO> findCartAll(HttpSession session);

    /**
     * 查询当前登陆用户的所有信息（未删除的）（管理员专用）
     * @return
     */
    List<CartVO> findCartAllByRoot();

    /**
     * 通过cid删除当前信息
     * @return
     */
    void deleteByCid(Integer cid);
}
