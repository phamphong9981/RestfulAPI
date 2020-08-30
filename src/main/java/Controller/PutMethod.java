package Controller;

import Additional.ChangeLineInFile;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.*;
import java.util.Scanner;

@Path("customers")
public class PutMethod {
    @Path("{id}")
    @PUT
    @Consumes({MediaType.APPLICATION_FORM_URLENCODED})
    public void createCustomer( @PathParam("id") int id,
                                    @FormParam("name") String name,
                                    @FormParam("address") String address,
                                    @FormParam("phone") String number){
        try {
            Scanner sc=new Scanner(new File("C:\\Users\\Pham Phong\\IdeaProjects\\RestfulAPI\\src\\main\\java\\customer.txt"));
            int tmp=sc.nextInt();
            if(id>tmp){
                ChangeLineInFile changeFile = new ChangeLineInFile();
                changeFile.changeALineInATextFile("C:\\Users\\Pham Phong\\IdeaProjects\\RestfulAPI\\src\\main\\java\\customer.txt", Integer.toString(++tmp), 1);
                FileWriter fileWriter=new FileWriter("C:\\Users\\Pham Phong\\IdeaProjects\\RestfulAPI\\src\\main\\java\\customer.txt",true);
                BufferedWriter bufferedWriter=new BufferedWriter(fileWriter);
                PrintWriter printWriter=new PrintWriter(bufferedWriter);
                printWriter.println(id+"#"+name+"#"+address+"#"+number);
                printWriter.close();
                bufferedWriter.close();
                fileWriter.close();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
