package gm.resources;

import gm.api.Holiday;
import gm.api.HolidayDAO;
import io.dropwizard.hibernate.UnitOfWork;
import io.dropwizard.jersey.params.IntParam;

import javax.ws.rs.*;
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

    @GET
    @UnitOfWork
    @Path("/{idUser}")
    public List<Holiday> findByUser(@PathParam("idUser") IntParam idUser) {
        return holidayDAO.findByUser(idUser.get());
    }
}
