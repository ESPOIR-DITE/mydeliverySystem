package repository.orderRepository;

import Builder.itemBuilder.ItemInterface;
import Builder.itemBuilder.ItemProduct;
import domain.OrderClass;

import java.util.ArrayList;

public class OrderRep implements OrderRepositoryIn {
    @Override
    public ArrayList<OrderClass> orderList() {
        return null;
    }




    @Override
    public OrderClass create(OrderClass orderClass) {
        return null;
    }

    @Override
    public OrderClass update(OrderClass orderClass) {
        return null;
    }

    @Override
    public void delete(String s) {

    }

    @Override
    public OrderClass read(String s) {
        return null;
    }

    @Override
    public ItemProduct readAll(String type) {
        return null;
    }


    public ItemInterface readAll() {
        return null;
    }

    @Override
    public OrderClass insert(OrderClass orderClass) {
        return null;
    }
}
