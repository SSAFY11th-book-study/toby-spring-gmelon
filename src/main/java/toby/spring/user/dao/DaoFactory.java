package toby.spring.user.dao;

import com.mysql.cj.jdbc.Driver;
import java.sql.DriverManager;
import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import toby.spring.account.dao.AccountDao;
import toby.spring.message.dao.MessageDao;

@Configuration
public class DaoFactory {
    @Bean
    public UserDao userDao() {
        return new UserDao(dataSource());
    }

//    public AccountDao accountDao() {
//        ConnectionMaker connectionMaker = dataSource();
//        return new AccountDao(connectionMaker);
//    }
//
//    public MessageDao messageDao() {
//        ConnectionMaker connectionMaker = dataSource();
//        return new MessageDao(connectionMaker);
//    }

    @Bean
    public DataSource dataSource() {
        SimpleDriverDataSource dataSource = new SimpleDriverDataSource();

        dataSource.setDriverClass(Driver.class);
        dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/tobyspring");
        dataSource.setUsername("root");
        dataSource.setPassword("0323");

        return dataSource;
    }
}
