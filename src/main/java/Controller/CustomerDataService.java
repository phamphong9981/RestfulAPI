package Controller;

import Model.Customer;
import org.fluttercode.datafactory.impl.DataFactory;

import java.util.ArrayList;
import java.util.List;

public class CustomerDataService {
    private List<Customer> customerList;

    private static CustomerDataService ourInstance = new CustomerDataService();

    public static CustomerDataService getInstance() {
        return ourInstance;
    }

    private CustomerDataService() {
        customerList = new ArrayList<Customer>();
        //creating some dummy customers
        DataFactory dataFactory = new DataFactory();
        for (int i = 1; i <= 5; i++) {
            Customer customer = new Customer(Integer.toString(i));
            customer.setName("dataFactory.getName()");
            customer.setAddress("dataFactory.getAddress()");
            customer.setPhoneNumber("");
            customerList.add(customer);
        }
    }

    public List<Customer> getCustomerList() {
        return customerList;
    }


}