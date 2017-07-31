package test;

import bean.User;
import dao.UserDAO;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2017/7/31.
 */
public class UserDAOTest {
    @Test
    public void getUser() throws Exception {
        String name = "tom";
        String password = "123";
        User u = new UserDAO().getUser(name,password);
        System.out.println(u);
    }

}