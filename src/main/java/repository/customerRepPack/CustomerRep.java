package repository.customerRepPack;

import domain.CustomerDetails;
import repository.Irepository;

import java.util.List;

public interface CustomerRep extends Irepository<CustomerDetails, String>
{
    List<CustomerDetails> getAll();
}