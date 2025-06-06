package application;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Seller;

public class Program {

    public static void main(String[] args) {

        SellerDao sellerDao = DaoFactory.createSellerDao();

        System.out.println("--- Test 1: Find seller by Id ---");
        Seller seller = sellerDao.findById(3);

        System.out.println(seller);

    }
}
