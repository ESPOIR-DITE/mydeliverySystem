package repository;

import Builder.itemBuilder.ItemInterface;
import Builder.itemBuilder.ItemProduct;

public interface Irepository<T,ID>
{
    T create(T t);
    T update(T t);
    void delete(ID id);
    T read(ID id);
    ItemProduct readAll(String type);
    T insert(T t);
}//end repository
