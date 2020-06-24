package cn.aylcy.entity;

import java.io.Serializable;

/**
 * 用户实体
 */
public class User implements Serializable {
    private Integer uid;//
    private String  username;//用户名
    private String  password;//密码
    private Integer isRoot;//是否管理员

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getIsRoot() {
        return isRoot;
    }

    public void setIsRoot(Integer isRoot) {
        this.isRoot = isRoot;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", isRoot=" + isRoot +
                '}';
    }
}
