package org.itstep.jdbc.service;

import org.itstep.jdbc.entity.Items;

import java.util.List;

public interface ShopService {
    void getAllItem();
    void deleteItem(Integer id);
    void AddItem(String name , Double price);

}
