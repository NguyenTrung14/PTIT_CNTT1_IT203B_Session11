package ex5.Dao;

import ex5.DBContext;
import ex5.entity.Doctor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DoctorDao {

    public List<Doctor> findAll() {
        List<Doctor> doctors = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = DBContext.getConnection();
            String sql = "select doctor_id, full_name, speciality from doctors";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Doctor doctor = new Doctor();
                doctor.setDoctorId(rs.getString("doctor_id"));
                doctor.setFullName(rs.getString("full_name"));
                doctor.setSpeciality(rs.getString("speciality"));
                doctors.add(doctor);
            }
        } catch (Exception e) {
            System.out.println("loi lay danh sach bac si: " + e.getMessage());
        } finally {
            DBContext.closeAll(conn, ps, rs);
        }

        return doctors;
    }

    public boolean insertDoctor(Doctor doctor) {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = DBContext.getConnection();
            String sql = "insert into doctors(doctor_id, full_name, speciality) values (?, ?, ?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1, doctor.getDoctorId());
            ps.setString(2, doctor.getFullName());
            ps.setString(3, doctor.getSpeciality());

            int rows = ps.executeUpdate();
            return rows > 0;
        } catch (Exception e) {
            System.out.println("loi them bac si: " + e.getMessage());
            return false;
        } finally {
            DBContext.closeAll(conn, ps, null);
        }
    }

    public List<String> countBySpeciality() {
        List<String> result = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = DBContext.getConnection();
            String sql = "select speciality, count(*) as total from doctors group by speciality";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                String speciality = rs.getString("speciality");
                int total = rs.getInt("total");
                result.add("chuyen khoa: " + speciality + " | so luong bac si: " + total);
            }
        } catch (Exception e) {
            System.out.println("loi thong ke chuyen khoa: " + e.getMessage());
        } finally {
            DBContext.closeAll(conn, ps, rs);
        }

        return result;
    }
}