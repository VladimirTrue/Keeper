package entity.dao;

import org.hibernate.Session;

public class PeriodDao {

    private Session session;

    public PeriodDao(Session session) {
        this.session = session;
    }


}
