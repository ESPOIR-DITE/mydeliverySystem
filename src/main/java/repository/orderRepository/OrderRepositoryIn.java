package repository.orderRepository;

import domain.OrderClass;
import repository.Irepository;

import java.util.ArrayList;

public interface OrderRepositoryIn extends Irepository<OrderClass,String>
{
    ArrayList<OrderClass>orderList();
}
