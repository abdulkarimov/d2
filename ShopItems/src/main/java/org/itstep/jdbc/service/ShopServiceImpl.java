package org.itstep.jdbc.service;

import org.itstep.jdbc.config.ShopDBManager;
import org.itstep.jdbc.entity.Items;

import java.util.List;

public class ShopServiceImpl implements ShopService {
    ShopDBManager shdbm;
    {
        shdbm = new ShopDBManager();
        try {
            shdbm.setConnection();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void getAllItem() {
        shdbm.getAllItemspls();
    }

    @Override
    public void deleteItem(Integer id) {
        shdbm.DeleteByID(id);
    }

    @Override
    public void AddItem(String name, Double price) {
        shdbm.AddItem(name,price);
    }
}
