package cn.figo.dao;

import cn.figo.domain.Account;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author Figo
 * @Date 2019/12/6 0:17
 */
@Repository
public interface AccountDao {

    // 查询所有账户
    @Select("select * from account")
    public List<Account> findAll();

    // 保存帐户信息
    @Insert("insert into account (name,money) values (#{name},#{money})")
    public void saveAccount(Account account);

}
