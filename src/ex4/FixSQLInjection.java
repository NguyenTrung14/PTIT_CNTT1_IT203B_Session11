package ex4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class FixSQLInjection {
    public static String sanitizeInput(String input) {
        if (input == null) return "";
        input = input.replace("'", "");
        input = input.replace("--", "");
        input = input.replace(";", "");
        return input;
    }

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/hospital_db";
        String user = "root";
        String password = "nguyentrung243";

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("nhap ten benh nhan: ");
            String patientName = scanner.nextLine();
            patientName = sanitizeInput(patientName);
            conn = DriverManager.getConnection(url, user, password);
            stmt = conn.createStatement();
            String sql = "select * from patients where full_name = '" + patientName + "'";
            rs = stmt.executeQuery(sql);
            boolean empty = true;
            while (rs.next()) {
                empty = false;
                System.out.println("ten: " + rs.getString("full_name"));
            }
            if (empty) {
                System.out.println("khong tim thay benh nhan");
            }
        } catch (Exception e) {
            System.out.println("loi: " + e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}