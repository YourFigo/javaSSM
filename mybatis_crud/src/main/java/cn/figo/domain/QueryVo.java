package cn.figo.domain;

import java.util.List;

/**
 * @Author Figo
 * @Date 2019/10/29 22:05
 */
public class QueryVo {

    private User user;
    private List<Integer> ids;

    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
