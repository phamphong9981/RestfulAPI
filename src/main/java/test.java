import Additional.ChangeLineInFile;
import Model.Customer;

import java.io.*;
import java.util.Scanner;

public class test {
    public static void main(String[] args) {
//        FileWriter fw = null;
//        BufferedWriter bw = null;
//        PrintWriter out = null;
//        try {
//            fw = new FileWriter("C:\\Users\\Pham Phong\\IdeaProjects\\RestfulAPI\\src\\main\\java\\customer.txt", true);
//            bw = new BufferedWriter(fw);
//            out = new PrintWriter(bw);
//            out.println("\r\n4#ngoctrinh#thaibinh#0444443333");
//            out.close();
//        } catch (IOException e) {
//            //exception handling left as an exercise for the reader
//        }
//        finally {
//            if(out != null)
//                out.close();
//            try {
//                if(bw != null)
//                    bw.close();
//            } catch (IOException e) {
//                //exception handling left as an exercise for the reader
//            }
//            try {
//                if(fw != null)
//                    fw.close();
//            } catch (IOException e) {
//                //exception handling left as an exercise for the reader
//            }
//        }
        Scanner sc= null;
        try {
            sc = new Scanner(new File("C:\\Users\\Pham Phong\\IdeaProjects\\RestfulAPI\\src\\main\\java\\customer.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        int id=sc.nextInt();
        System.out.println(id);
    }
}
