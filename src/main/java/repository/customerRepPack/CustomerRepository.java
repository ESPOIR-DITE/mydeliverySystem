package repository.customerRepPack;

import domain.CustomerDetails;
import repository.CustomerRep;

import java.util.*;

public class CustomerRepository implements CustomerRep
{
    private static CustomerRepository rep =null;
    private ArrayList<CustomerDetails> customerDetailsList;

    private CustomerRepository()
    {
        this.customerDetailsList = new ArrayList<>();
    }

    public static CustomerRepository getRepository()
    {
        if(rep==null)rep=new CustomerRepository();
        return rep;
    }

    @Override
    public CustomerDetails create(CustomerDetails customerDetails) {
        this.customerDetailsList.add(customerDetails);
        return customerDetails;
    }

    @Override
    public CustomerDetails update(CustomerDetails customerDetails) {

        this.customerDetailsList.add(0,customerDetails);
        return customerDetails;
    }

    @Override
    public void delete(String s) {
        this.customerDetailsList.clear();

    }

    @Override
    public CustomerDetails read(String s) {
        for(int i=0;i<customerDetailsList.size();i++) {
            System.out.println(customerDetailsList.get(i));
        }
        return null;
    }
    @Override
    public List<CustomerDetails> getAll() {
        return customerDetailsList;
    }
}
