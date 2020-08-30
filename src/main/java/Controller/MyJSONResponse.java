package Controller;

import Model.Customer;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Path("customers")
public class MyJSONResponse {
    @GET
    @Path("json")
    @Produces(MediaType.APPLICATION_JSON)
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
