package org.itstep.jdbc;

import org.itstep.jdbc.config.ShopDBManager;
import org.itstep.jdbc.service.ShopService;
import org.itstep.jdbc.service.ShopServiceImpl;

import java.sql.SQLException;
import java.util.Scanner;

public class JdbcManager {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Boolean f = true;
        ShopService service = new ShopServiceImpl();
        Scanner cin = new Scanner(System.in);

        while (f) {
            System.out.println("  PRESS [1] TO ADD ITEMS ");
            System.out.println("  PRESS [2] TO LIST ITEMS  ");
            System.out.println("  PRESS [3] TO DELETE ITEMS ");
            System.out.println("    PRESS [0] TO EXIT  ");

            Integer press = cin.nextInt();

            switch (press) {
                case (1):
                    System.out.println(" name ");
                    String name = cin.next();
                    System.out.println(" price");
                    Double price = cin.nextDouble();
                    service.AddItem(name, price);
                    break;
                case (2):
                    service.getAllItem();
                    break;
                case (3):
                    System.out.println(" id item for delete ");
                    Integer id = cin.nextInt();
                    service.deleteItem(id);
                    break;
                case (0):
                    f = false;

           }
        }
    }
}