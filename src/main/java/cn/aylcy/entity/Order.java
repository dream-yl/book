package cn.aylcy.entity;

import java.io.Serializable;
import java.util.List;

public class Order implements Serializable {
    private Integer oid;//id
    private Integer uid;//用户id
    private String sumPrice;//总金额
    private String  purchaseName;//购买人
    private String  address;//地址
    private  String  phone;//电话
    private  String  eMail;//电子邮箱
    private  Integer isState;//状态
    private  Integer isDelete;//是否删除
    private  String createTime;//创建时间
    private List<OrderItem> list;

    public List<OrderItem> getList() {
        return list;
    }

    public void setList(List<OrderItem> list) {
        this.list = list;
    }

    public Integer getOid() {
        return oid;
    }

    public void setOid(Integer oid) {
        this.oid = oid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getSumPrice() {
        return sumPrice;
    }

    public void setSumPrice(String sumPrice) {
        this.sumPrice = sumPrice;
    }

    public String getPurchaseName() {
        return purchaseName;
    }

    public void setPurchaseName(String purchaseName) {
        this.purchaseName = purchaseName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public Integer getIsState() {
        return isState;
    }

    public void setIsState(Integer isState) {
        this.isState = isState;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Order{" +
                "oid=" + oid +
                ", uid=" + uid +
                ", sumPrice='" + sumPrice + '\'' +
                ", purchaseName='" + purchaseName + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", eMail='" + eMail + '\'' +
                ", isState=" + isState +
                ", isDelete=" + isDelete +
                ", createTime='" + createTime + '\'' +
                '}';
    }
}
