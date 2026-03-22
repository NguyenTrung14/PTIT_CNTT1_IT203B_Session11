package ex2.Dao;

import ex2.DBContext;
import ex2.entity.Medicine;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PharmacyDao {

    public List<Medicine> getAllMedicines() {
        List<Medicine> medicines = new ArrayList<>();

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            conn = DBContext.getConnection();

            stmt = conn.createStatement();
            String sql = "select id, medicine_name, stock from pharmacy";

            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Medicine m = new Medicine();
                m.setId(rs.getInt("id"));
                m.setMedicineName(rs.getString("medicine_name"));
                m.setStock(rs.getInt("stock"));

                medicines.add(m);
            }

        } catch (Exception e) {
            System.out.println("loi lay danh sach thuoc: " + e.getMessage());
        } finally {
            DBContext.closeAll(conn, stmt, rs);
        }

        return medicines;
    }

    public void printMedicines() {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            conn = DBContext.getConnection();

            stmt = conn.createStatement();
            String sql = "select medicine_name, stock from pharmacy";

            rs = stmt.executeQuery(sql);

            boolean empty = true;

            System.out.println("danh sach thuoc:");
            System.out.println("----------------");

            while (rs.next()) {
                empty = false;

                String name = rs.getString("medicine_name");
                int stock = rs.getInt("stock");

                System.out.println(name + " - so luong: " + stock);
            }

            if (empty) {
                System.out.println("kho thuoc rong");
            }

        } catch (Exception e) {
            System.out.println("loi in thuoc: " + e.getMessage());
        } finally {
            DBContext.closeAll(conn, stmt, rs);
        }
    }
}