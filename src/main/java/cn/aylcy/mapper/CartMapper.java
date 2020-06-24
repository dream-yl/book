package cn.aylcy.mapper;

import cn.aylcy.entity.Cart;
import cn.aylcy.entity.CartVO;

import java.util.List;

/**
 * 购物车持久层接口
 */
public interface CartMapper {

    /**
     * 添加
     * @param cart
     * @return
     */
    Integer addCart(Cart cart);

    /**
     * 查询当前登陆用户的所有信息（未删除的）
     * @param uid
     * @return
     */
    List<CartVO> findCartAll(Integer uid);

    /**
     * 通过cid查询信息
     * @param cid
     * @return
     */
    CartVO findCartByCid(Integer cid);
    /**
     * 查询当前登陆用户的所有信息（未删除的）（管理员专用）
     * @return
     */
    List<CartVO> findCartAllByRoot();

    /**
     * 通过cid删除当前信息
     * @return
     */
    Integer deleteByCid(Integer cid);
}
