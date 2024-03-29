import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        SellerDao sellerDao = DaoFactory.createSellerDao();
        System.out.println("=== Test1: Seller findById ===");
        Seller seller = sellerDao.findById(3);
        System.out.println(seller);

        System.out.println();

        System.out.println("=== Test2: Seller findByDepartment ===");
        Department department = new Department(3, null);
        List<Seller> list = sellerDao.findByDepartment(department);
        for(Seller obj : list){
            System.out.println(obj);
        }

        System.out.println();

        System.out.println("=== Test3: Seller findAll ===");
        list = sellerDao.findAll();
        for(Seller obj : list){
            System.out.println(obj);
        }

        System.out.println();

        System.out.println("=== Test4: Seller Insert ===");
        Seller newSeller = new Seller(null, "Greg", "greg@gmail.com",new Date(), 4000.0, department);
        sellerDao.insert(newSeller);
        System.out.println("Inserted! New id= " + newSeller.getId());

        System.out.println();

        System.out.println("=== Test5: Seller Update ===");
        seller = sellerDao.findById(1);
        seller.setName("Marta Waine");
        sellerDao.update(seller);
        System.out.println("Update completed");

        System.out.println();

        System.out.println("=== Test6: Seller Delete ===");
        System.out.println("Enter id for delete test: ");
        int id = sc.nextInt();
        sellerDao.deleteById(id);
        System.out.println("Delete completed!");

        sc.close();

    }
}