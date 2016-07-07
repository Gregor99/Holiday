package gm.resources;

import gm.api.Holiday;
import gm.api.HolidayDAO;
import io.dropwizard.hibernate.UnitOfWork;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by Gregor on 6. 07. 2016.
 */

@Path("/holidays")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class HolidayResource {

    private final HolidayDAO holidayDAO;

    public HolidayResource(HolidayDAO hDAO) {
        this.holidayDAO = hDAO;
    }

    @GET
    @UnitOfWork
    public List<Holiday> viewAll() {
        return holidayDAO.findAll();
    }
}
