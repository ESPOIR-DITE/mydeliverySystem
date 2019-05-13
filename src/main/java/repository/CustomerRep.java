package repository;

import domain.CustomerDetails;

import java.util.List;

public interface CustomerRep extends Irepository<CustomerDetails, String>
{
    List<CustomerDetails> getAll();
}
