package cn.aylcy.entity;

import java.io.Serializable;

/**
 * 书籍实体
 */
public class Book implements Serializable {
       private Integer  bid;//图书id
       private String   titleName;//书名
       private String   authorName;//作者
       private double   unitPrice;//单价
       private String   briefIntroduction;//简介
       private Integer  isShelf;//是否上架

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public String getTitleName() {
        return titleName;
    }

    public void setTitleName(String titleName) {
        this.titleName = titleName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getBriefIntroduction() {
        return briefIntroduction;
    }

    public void setBriefIntroduction(String briefIntroduction) {
        this.briefIntroduction = briefIntroduction;
    }

    public Integer getIsShelf() {
        return isShelf;
    }

    public void setIsShelf(Integer isShelf) {
        this.isShelf = isShelf;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bid=" + bid +
                ", titleName='" + titleName + '\'' +
                ", authorName='" + authorName + '\'' +
                ", unitPrice=" + unitPrice +
                ", briefIntroduction='" + briefIntroduction + '\'' +
                ", isShelf=" + isShelf +
                '}';
    }
}
