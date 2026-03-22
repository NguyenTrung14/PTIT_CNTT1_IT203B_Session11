package ex1.Dao;

import ex1.DBContext;
import ex1.entity.Doctor;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DoctorDao {

    public List<Doctor> getDoctors() {
        List<Doctor> doctors = new ArrayList<>();

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            conn = DBContext.getConnection();

            stmt = conn.createStatement();
            String sql = "select id, name, speciality from doctor";

            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Doctor d = new Doctor();
                d.setId(rs.getInt("id"));
                d.setName(rs.getString("name"));
                d.setSpeciality(rs.getString("speciality"));

                doctors.add(d);
            }

        } catch (Exception e) {
            System.out.println("loi lay doctor: " + e.getMessage());
        } finally {
            DBContext.closeAll(conn, stmt, rs);
        }

        return doctors;
    }
}