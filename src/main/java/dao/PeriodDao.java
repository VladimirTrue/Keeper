package dao;

import com.sun.istack.NotNull;
import entity.Period;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class PeriodDao implements DAO<Period, Integer> {

    private final SessionFactory factory;

    public PeriodDao(@NotNull final SessionFactory factory) {
        this.factory = factory;
    }


    @Override
    public void create(@NotNull final Period period) {
        try (final Session session = factory.openSession()) {

            session.beginTransaction();

            session.save(period);

            session.getTransaction().commit();
        }
    }

    @Override
    public Period read(Integer id) {
        try (final Session session = factory.openSession()) {

            final Period result = session.get(Period.class, id);

            if (result != null) {
                Hibernate.initialize(result.getIncomesList());
                Hibernate.initialize(result.getExpensesList());
                Hibernate.initialize(result.getDayList());
            }

            return result;
        }
    }

    @Override
    public void update(Period period) {
        try (Session session = factory.openSession()) {

            session.beginTransaction();

            session.update(period);

            session.getTransaction().commit();
        }
    }

    @Override
    public void delete(Period period) {
        try (Session session = factory.openSession()) {

            session.beginTransaction();

            session.delete(period);

            session.getTransaction().commit();
        }
    }

}

