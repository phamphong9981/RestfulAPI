package Controller;

import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

@Path("customers")
public class DeleteMethod {
    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") int id){
        return Response.ok("Item "+id+" has been deleted").build();
    }
}
