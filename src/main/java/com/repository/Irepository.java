package com.repository;

import com.Builder.itemBuilder.ItemProduct;

public interface Irepository<T,ID>
{
    T create(T t);
    T update(T t);
    void delete(ID id);
    T read(ID id);
    T readAll(String type);
    int getItemNumber();

}//end com.repository
