package Controller;

import javax.ws.rs.HEAD;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("customers")
public class HeadMethod {
    @HEAD
    @Path("head")
    public Response headString(){
        return Response.ok("Head Method").build();
    }
}
