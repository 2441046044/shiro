package com.qfedu.shiro;

import com.qfedu.shiro.dao.UserDao;
import com.qfedu.shiro.entity.MenuInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ShiroApplicationTests {

    @Autowired(required = false)
    private UserDao userDao;
    @Test
    public void contextLoads() {
        List<MenuInfo> list = userDao.findMenuInfo(1);
        for(MenuInfo info : list){
            System.out.println(info.getMenuName());

            List<MenuInfo> childMenus = info.getChildMenus();

            for (MenuInfo cinfo:childMenus){
                System.out.println(cinfo.getMenuName());
            }
        }
    }

}
