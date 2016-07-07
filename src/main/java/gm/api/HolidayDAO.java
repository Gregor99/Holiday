package gm.api;

import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by Gregor on 6. 07. 2016.
 */

public class HolidayDAO extends AbstractDAO<Holiday> {

    public HolidayDAO(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public List<Holiday> findAll() {
        return list(namedQuery("findAll"));
    }
}
