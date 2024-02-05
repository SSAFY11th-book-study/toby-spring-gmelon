package toby.spring.user.dao;

import toby.spring.account.dao.AccountDao;
import toby.spring.message.dao.MessageDao;

public class DaoFactory {
    public UserDao userDao() {
        ConnectionMaker connectionMaker = connectionMaker();
        return new UserDao(connectionMaker);
    }

    public AccountDao accountDao() {
        ConnectionMaker connectionMaker = connectionMaker();
        return new AccountDao(connectionMaker);
    }

    public MessageDao messageDao() {
        ConnectionMaker connectionMaker = connectionMaker();
        return new MessageDao(connectionMaker);
    }

    private DConnectionMaker connectionMaker() {
        return new DConnectionMaker();
    }
}
