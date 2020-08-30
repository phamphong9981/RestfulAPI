package Controller;

import Controller.CustomerDataService;
import Model.Customer;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("customers1")
public class CustomerRestService {
    private CustomerDataService customerDataService = CustomerDataService.getInstance();

    @GET
    @Produces(MediaType.APPLICATION_XML)
    public List<Customer> getCustomers () {
        return customerDataService.getCustomerList();
    }
}