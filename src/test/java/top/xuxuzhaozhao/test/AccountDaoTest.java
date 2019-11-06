package top.xuxuzhaozhao.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import top.xuxuzhaozhao.service.IAccountService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:bean.xml")
public class AccountDaoTest {

    @Autowired
    private IAccountService as;

    @Test
    public void TestFindAccountByName() throws Exception {
        as.transfer(1,2, (double) 100);
    }
}
