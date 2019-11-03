package cn.figo.domain;

import java.io.Serializable;

/**
 * 账户表
 * @Author Figo
 * @Date 2019/11/3 14:44
 */
public class Account implements Serializable {

    private Integer aid;
    private Integer uid;
    private Double money;

    //从表实体应该包含一个主表实体的对象引用
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getId() {
        return aid;
    }

    public void setId(Integer id) {
        this.aid = id;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + aid +
                ", uid=" + uid +
                ", money=" + money +
                '}';
    }
}
