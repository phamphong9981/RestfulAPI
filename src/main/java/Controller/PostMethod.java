package Controller;

import Additional.ChangeLineInFile;
import Model.Customer;
import com.sun.org.glassfish.gmbal.ParameterNames;
import jdk.nashorn.internal.parser.JSONParser;
import org.json.JSONException;
import org.json.JSONObject;

import javax.jws.WebParam;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.*;
import java.util.Scanner;

@Path("customers")
public class PostMethod {
    @POST
    @Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON,MediaType.APPLICATION_FORM_URLENCODED})
    @Produces(MediaType.TEXT_PLAIN)
    public void addCustomer(String body){
        JSONObject json = null;
        try {
            json = new JSONObject(body);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        String name= null;
        String address=null;
        String phoneNumber=null;
        try {
            name = json.getString("name");
            address=json.getString("address");
            phoneNumber=json.getString("phone-number");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            Scanner sc=new Scanner(new File("C:\\Users\\Pham Phong\\IdeaProjects\\RestfulAPI\\src\\main\\java\\customer.txt"));
            int id=sc.nextInt();
            FileWriter fw = null;
            BufferedWriter bw = null;
            PrintWriter out = null;
            try {
                fw = new FileWriter("C:\\Users\\Pham Phong\\IdeaProjects\\RestfulAPI\\src\\main\\java\\customer.txt", true);
                bw = new BufferedWriter(fw);
                out = new PrintWriter(bw);
                out.println((++id)+"#"+name+"#"+address+"#"+phoneNumber);
                out.close();
            } catch (IOException e) {
                //exception handling left as an exercise for the reader
            }
            finally {
                if(out != null)
                    out.close();
                try {
                    if(bw != null)
                        bw.close();
                } catch (IOException e) {
                    //exception handling left as an exercise for the reader
                }
                try {
                    if(fw != null)
                        fw.close();
                } catch (IOException e) {
                    //exception handling left as an exercise for the reader
                }
            }
            ChangeLineInFile changeFile = new ChangeLineInFile();
            changeFile.changeALineInATextFile("C:\\Users\\Pham Phong\\IdeaProjects\\RestfulAPI\\src\\main\\java\\customer.txt", Integer.toString(id), 1);
            sc.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
