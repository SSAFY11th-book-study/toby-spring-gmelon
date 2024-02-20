package toby.spring.user.dao;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.sql.SQLException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.dao.EmptyResultDataAccessException;
import toby.spring.user.domain.User;

public class UserDaoTest {

    private UserDao dao;
    private User user1;
    private User user2;
    private User user3;

    @Before
    public void setUp() {
        ApplicationContext context = new AnnotationConfigApplicationContext(DaoFactory.class);
        dao = context.getBean("userDao", UserDao.class);

        user1 = new User("amelon", "에이", "a");
        user2 = new User("bmelon", "비", "b");
        user3 = new User("cmelon", "씨", "c");
    }

    @Test
    public void addAndGet() throws SQLException, ClassNotFoundException {
        dao.deleteAll();
        assertThat(dao.getCount(), is(0));

        dao.add(user1);
        dao.add(user2);
        assertThat(dao.getCount(), is(2));

        User userGet1 = dao.get(user1.getId());
        assertThat(userGet1.getName(), is(user1.getName()));
        assertThat(userGet1.getPassword(), is(user1.getPassword()));

        User userGet2 = dao.get(user2.getId());
        assertThat(userGet2.getName(), is(user2.getName()));
        assertThat(userGet2.getPassword(), is(user2.getPassword()));
    }

    @Test
    public void count() throws SQLException, ClassNotFoundException {
        dao.deleteAll();
        assertThat(dao.getCount(), is(0));

        dao.add(user1);
        assertThat(dao.getCount(), is(1));

        dao.add(user2);
        assertThat(dao.getCount(), is(2));

        dao.add(user3);
        assertThat(dao.getCount(), is(3));
    }

    @Test(expected = EmptyResultDataAccessException.class)
    public void getUserFailure() throws SQLException, ClassNotFoundException {
        dao.deleteAll();
        assertThat(dao.getCount(), is(0));

        dao.get("invalid id");
    }

    public static void main(String[] args) {
        JUnitCore.main("toby.spring.user.dao.UserDaoTest");
    }
}
