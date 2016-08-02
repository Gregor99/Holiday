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

    public List<Holiday> findByUser(Integer idUser) {
        return list(namedQuery("findByUser").setParameter("idUser", idUser));
    }

    public Holiday findById(Integer idHoliday) {
        return get(idHoliday);
    }

    public Holiday saveToDataBase(Holiday holiday) {
        currentSession().save(holiday);
        return holiday;
    }

    public void deleteFromDataBase(Integer idHoliday) {
        currentSession().delete(new Holiday(idHoliday));
    }

//    public Holiday uredi (Integer idHolidayOld, Holiday holidayNew) {
//        holidayNew.setIdUser(idHolidayOld);
//        currentSession().update(holidayNew);
//        return holidayNew;
//    }
}
