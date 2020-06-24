package cn.aylcy.entity;

import java.io.Serializable;

/**
 * 购物车实体
 */
public class Cart implements Serializable {

    private Integer cid;//购物车id
    private Integer uid;//用户id
    private Integer bid;//书籍id
    private Integer count;//数量
    private Integer isDelete;//是否删除

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "cid=" + cid +
                ", uid=" + uid +
                ", bid=" + bid +
                ", count=" + count +
                ", isDelete=" + isDelete +
                '}';
    }
}
