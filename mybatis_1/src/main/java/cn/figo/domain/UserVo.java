package cn.figo.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author Figo
 * @Date 2019/11/27 20:30
 */
public class UserVo implements Serializable {

    private Integer id;
    private String username;
    private Date birthday;
    private String sex;
    private String address;
    private String newField;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNewField() {
        return newField;
    }

    public void setNewField(String newField) {
        this.newField = newField;
    }

    @Override
    public String toString() {
        return "UserVo{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", birthday=" + birthday +
                ", sex='" + sex + '\'' +
                ", address='" + address + '\'' +
                ", newField='" + newField + '\'' +
                '}';
    }
}
