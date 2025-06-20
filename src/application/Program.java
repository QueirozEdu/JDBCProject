package application;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        SellerDao sellerDao = DaoFactory.createSellerDao();

        System.out.println("--- Test 1: Find seller by Id ---");
        Seller seller = sellerDao.findById(3);

        System.out.println(seller);
        System.out.println("\n\n");

        System.out.println("--- Test 2: Find seller by Department ---");
        Department department = new Department(2, null);
        List<Seller> list = sellerDao.findByDepartment(department);
        for (Seller obj :
             list) {
            System.out.println(obj);
        }
        System.out.println("\n\n");


        System.out.println("--- Test 3: Find all sellers ---");
        list = sellerDao.findAll();
        for (Seller obj :
             list) {
            System.out.println(obj);
        }
        System.out.println("\n\n");

        System.out.println("--- Test 4: Seller insert ---");
        Seller newSeller = new Seller(null, "Greg", "greg@gmail.com", new Date(), 4000.0, department);
        sellerDao.insert(newSeller);
        System.out.println("New seller with ID " + newSeller.getId() + " inserted");
        System.out.println("\n\n");

        System.out.println("--- Test 5: Update seller ---");
        seller = sellerDao.findById(1);
        seller.setName("Martha Wainer");
        sellerDao.update(seller);
        System.out.println("Update completed");
        System.out.println("Seller with ID " + sellerDao.findById(1).getId() + " updated");
        System.out.println(sellerDao.findById(1));
        System.out.println("\n\n");

        System.out.println("--- Test 6: Seller delete ---");
        System.out.println("Enter the ID of the seller to be deleted");
        int id = sc.nextInt();
        sellerDao.deleteById(id);
        System.out.println("Delete completed");
        sc.close();
        System.out.println("\n\n");

    }
}
