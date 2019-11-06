package top.xuxuzhaozhao.service.impl;

import top.xuxuzhaozhao.dao.IAccountDao;
import top.xuxuzhaozhao.domain.Account;
import top.xuxuzhaozhao.service.IAccountService;

public class AccountServiceImpl implements IAccountService {

    private IAccountDao accountDao;

    public void setAccountDao(IAccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public Account findAccountById(Integer accountId) throws Exception {
        return accountDao.findAccountById(accountId);
    }

    public void transfer(Integer sourceId, Integer targetId, Double money) throws Exception {
        accountDao.transfer(sourceId,targetId,money);
    }
}
