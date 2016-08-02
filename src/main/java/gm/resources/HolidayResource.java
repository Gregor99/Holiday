package gm.resources;

import gm.api.Holiday;
import gm.api.HolidayDAO;
import io.dropwizard.hibernate.UnitOfWork;
import io.dropwizard.jersey.params.IntParam;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
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

    @POST
    @UnitOfWork
    @Path("/{idUser}")
    public Response addHoliday(@Valid Holiday holiday) {
        return Response.created(UriBuilder.fromResource(HolidayResource.class).build()).entity(holidayDAO.saveToDataBase(holiday)).build();
    }

    @DELETE
    @UnitOfWork
    @Path("/{idUser}")
    public Response deleteHoliday(@PathParam("idUser") IntParam idUser) {
        holidayDAO.deleteFromDataBase(idUser.get());
        return Response.ok().build();
    }
}
