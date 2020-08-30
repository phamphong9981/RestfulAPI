package Controller;

import Model.Customer;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("response")
public class MyResponse {

    @GET
    @Path("{orderId:\\d+}/items/{itemId:[a-z]\\d{2,3}}")
    public Response getOrderItemByItemId(@PathParam("orderId") String orderId,
                                         @PathParam("itemId") String itemId) {
        return Response.status(Response.Status.OK)
                .entity("order id: " + orderId + " and item id: " + itemId)
                .build();
    }

    @GET
    @Path("{orderId}/items/{itemId}")
    public Response getInvalidOrderItemByItemId(@PathParam("orderId") String orderId,
                                                @PathParam("itemId") String itemId) {
        return Response.status(Response.Status.BAD_REQUEST)
                .build();
    }

    @GET
    @Path("genericEntity")
    @Produces(MediaType.APPLICATION_XML)
    public Response myResponse(){
        Customer customer1=new Customer("1");
        Customer customer2=new Customer("2");
        Customer customer3=new Customer("3");
        ArrayList<Customer> list=new ArrayList<Customer>();
        list.add(customer1);
        list.add(customer2);
        list.add(customer3);
        GenericEntity<ArrayList<Customer>> genericEntity=new GenericEntity<ArrayList<Customer>>(list){};
        return Response.ok(genericEntity).header("someheader","someheadervalue").build();
    }
}
