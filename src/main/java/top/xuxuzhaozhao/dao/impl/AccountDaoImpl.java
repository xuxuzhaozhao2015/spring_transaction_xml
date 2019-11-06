package top.xuxuzhaozhao.dao.impl;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import top.xuxuzhaozhao.dao.IAccountDao;
import top.xuxuzhaozhao.domain.Account;

import java.util.List;

/**
 * 此处直接继承子spring提供的JdbcDaoSupport(使用于xml配置)
 * 使用自定义的适用于使用注解配置
 */
public class AccountDaoImpl extends JdbcDaoSupport implements IAccountDao {

    public Account findAccountById(Integer accountId) throws Exception {
        List<Account> accounts = super.getJdbcTemplate().query("select * from account where uid=?",
                new BeanPropertyRowMapper<Account>(Account.class), accountId);
        if (accounts.size() == 0) return null;
        if (accounts.size() > 1) throw new Exception("结果集不唯一");

        return accounts.get(0);
    }

    public void transfer(Integer sourceId, Integer targetId, Double money) throws Exception {
        Account source = this.findAccountById(sourceId);
        Account target = this.findAccountById(targetId);

        source.setMoney(source.getMoney() - money);
        target.setMoney(target.getMoney() + money);

        updateAccount(source);
        int i = 12 / 0;
        updateAccount(target);
    }

    public void updateAccount(Account account) {
        super.getJdbcTemplate().update("update account set money=? where uid=?", account.getMoney(), account.getUid());
    }
}
