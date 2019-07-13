package com.service;

import com.sun.xml.internal.bind.v2.model.core.ID;

public interface Iservice<T,id>
{
    T create(T t);
    T update(T t);
 void delete(ID id);
    T read(ID id);
    T readAlll();
}
