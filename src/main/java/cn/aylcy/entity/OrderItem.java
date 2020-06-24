package cn.aylcy.entity;

import java.io.Serializable;

public class OrderItem implements Serializable {
    private Integer iid;//id
    private Integer oid;//订单id
    private Integer bid;//书籍id
    private Integer count;//数量
    private double price;//单价
    private String titleName;//书名

    public Integer getIid() {
        return iid;
    }

    public void setIid(Integer iid) {
        this.iid = iid;
    }

    public Integer getOid() {
        return oid;
    }

    public void setOid(Integer oid) {
        this.oid = oid;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getTitleName() {
        return titleName;
    }

    public void setTitleName(String titleName) {
        this.titleName = titleName;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "iid=" + iid +
                ", oid=" + oid +
                ", bid=" + bid +
                ", count=" + count +
                ", price=" + price +
                ", titleName='" + titleName + '\'' +
                '}';
    }
}
