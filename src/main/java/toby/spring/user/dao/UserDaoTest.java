package toby.spring.user.dao;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.sql.SQLException;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import toby.spring.user.domain.User;

public class UserDaoTest {
    @Test
    public void addAndGet() throws SQLException, ClassNotFoundException {
        ApplicationContext context = new AnnotationConfigApplicationContext(DaoFactory.class);
        UserDao dao = context.getBean("userDao", UserDao.class);

        dao.deleteAll();
        assertThat(dao.getCount(), is(0));

        User user = new User();
        user.setId("gmelon");
        user.setName("현상혁");
        user.setPassword("single");

        dao.add(user);
        assertThat(dao.getCount(), is(1));

        System.out.println(user.getId() + " 등록 성공");

        User user2 = dao.get(user.getId());
        assertThat(user2.getName(), is(user.getName()));
        assertThat(user2.getPassword(), is(user.getPassword()));
    }

    public static void main(String[] args) {
        JUnitCore.main("toby.spring.user.dao.UserDaoTest");
    }
}
