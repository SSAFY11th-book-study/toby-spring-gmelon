package toby.spring.user.dao;

import java.sql.SQLException;
import toby.spring.user.domain.User;

public class UserDaoTest {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        UserDao dao = new UserDao(new DConnectionMaker());

        User user = new User();
        user.setId("gmelon");
        user.setName("현상혁");
        user.setPassword("single");

        dao.add(user);

        System.out.println(user.getId() + " 등록 성공");

        User user2 = dao.get(user.getId());
        System.out.println(user.getName());
        System.out.println(user.getPassword());

        System.out.println(user2.getId() + " 조회 성공");
    }
}
