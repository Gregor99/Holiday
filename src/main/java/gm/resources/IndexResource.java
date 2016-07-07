package gm.resources;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by Gregor on 6. 07. 2016.
 */

@Path("/")
@Produces(MediaType.APPLICATION_JSON)
public class IndexResource {

    @JsonProperty
    private final String check = "URLju dodaj /holidays";

    public IndexResource() {}

    @GET
    public String indexCheck() {
        return check;
    }
}
