package dao;

import com.sun.istack.NotNull;
import entity.User;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


public class UserDao implements DAO<User, Long>{

    private final SessionFactory factory;

    public UserDao(@NotNull final SessionFactory factory) {
        this.factory = factory;
    }


    @Override
    public void create(User user) {
        try (final Session session = factory.openSession()) {

            session.beginTransaction();

            session.save(user);

            session.getTransaction().commit();
        }
    }

    @Override
    public User read(Long id) {

        try (final Session session = factory.openSession()) {

            final User result = session.get(User.class, id);

            if (result != null) {
                Hibernate.initialize(result.getPeriods());
            }

            return result;
        }
    }

    @Override
    public void update(User user) {
        try (Session session = factory.openSession()) {

            session.beginTransaction();

            session.update(user);

            session.getTransaction().commit();
        }
    }

    @Override
    public void delete(User user) {

        try (Session session = factory.openSession()) {

            session.beginTransaction();

            session.delete(user);

            session.getTransaction().commit();
        }
    }
}
