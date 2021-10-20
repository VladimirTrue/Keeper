package entity.dao;

import entity.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;

public class UserDao {

    private Session session;

    public UserDao(Session session) {
        this.session = session;
    }

    public long insertUser(User user) throws HibernateException {
        return (Long) session.save(user);
    }
    public User get(long id) throws HibernateException {
        //return session.get(UsersDataSet.class, id); // new hibernate 5.2.10.Final
        return (User) session.get(User.class, id);
    }
}
