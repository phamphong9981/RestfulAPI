package Controller;

import org.json.JSONObject;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

// The Java class will be hosted at the URI path "/helloworld"
@Path("customers")
public class GetMethod {

    //regex
    @GET
    @Path("{id}")
    public Response getMessenger(@PathParam("id") String id){
        File file=new File("C:\\Users\\Pham Phong\\IdeaProjects\\RestfulAPI\\src\\main\\java\\customer.txt");
        try {
            Scanner sc=new Scanner(file);
            sc.nextLine();
            while (sc.hasNextLine()){
                String[] array=sc.nextLine().split("#",5);
                if (array[0].equals(id)){
                    return Response.ok("{\n\t\"id\": \""+id+"\",\n\t\"name\": \""+array[1]+"\",\n\t\"address\": \""+array[2]+"\",\n\t\"phone-number\": \""+array[3]+"\"\n}").build();
                }
            }
            sc.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return Response.status(404).build();
    }

    //query param
    @GET
    public String getMess(@QueryParam("username") String username, @QueryParam("password") String password){
        return "Hello"+username;
    }
}