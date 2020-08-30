package Controller;

import Model.Customer;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

@Path("customers")
public class MyXMLResponse {
    @GET
    @Path("xml")
    @Produces(MediaType.APPLICATION_XML)
    public List<Customer> getCustomers(){
        List<Customer> list=new ArrayList<Customer>();
        File file=new File("C:\\Users\\Pham Phong\\IdeaProjects\\RestfulAPI\\src\\main\\java\\customer.txt");
        try {
            Scanner reader=new Scanner(file);
            reader.nextLine();
            while(reader.hasNextLine()){
                Customer customer=new Customer();
                String data=reader.nextLine();
                String[] array=data.split("#",5);
                customer.setId(array[0]);
                customer.setName(array[1]);
                customer.setAddress(array[2]);
                customer.setPhoneNumber(array[3]);
                list.add(customer);
            }
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return list;
    }

}
