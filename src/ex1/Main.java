package ex1;

import ex1.Dao.DoctorDao;
import ex1.entity.Doctor;

import java.sql.Connection;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Connection connection = null;

        try {
            connection = DBContext.getConnection();
            System.out.println("ket noi database thanh cong");
        } catch (Exception e) {
            System.out.println("ket noi database that bai: " + e.getMessage());
        } finally {
            DBContext.closeAll(connection, null, null);
        }

        DoctorDao doctorDao = new DoctorDao();
        List<Doctor> doctors = doctorDao.getDoctors();

        if (doctors.isEmpty()) {
            System.out.println("khong co du lieu doctor");
        } else {
            System.out.println("danh sach doctor:");
            for (Doctor doctor : doctors) {
                System.out.println(doctor);
            }
        }
    }
}