package ex2;

import ex2.Dao.PharmacyDao;
import ex2.entity.Medicine;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        PharmacyDao pharmacyDao = new PharmacyDao();
        pharmacyDao.printMedicines();;

        System.out.println();
        System.out.println("lay du lieu dang list:");

        List<Medicine> medicines = pharmacyDao.getAllMedicines();

        for (Medicine medicine : medicines) {
            System.out.println(medicine);
        }
    }
}