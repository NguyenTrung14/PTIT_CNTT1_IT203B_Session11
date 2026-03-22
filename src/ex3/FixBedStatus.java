package ex3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class FixBedStatus {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/hospital_db";
        String user = "root";
        String password = "nguyentrung243";

        Connection conn = null;
        Statement stmt = null;
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("nhap ma giuong: ");
            String inputId = scanner.nextLine();

            conn = DriverManager.getConnection(url, user, password);
            stmt = conn.createStatement();

            String sql = "update beds set bed_status = 'dang su dung' where bed_id = '" + inputId + "'";
            int rowsAffected = stmt.executeUpdate(sql);

            if (rowsAffected > 0) {
                System.out.println("cap nhat giuong benh thanh cong");
            } else {
                System.out.println("loi: khong tim thay ma giuong " + inputId);
            }

        } catch (Exception e) {
            System.out.println("loi: " + e.getMessage());
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}