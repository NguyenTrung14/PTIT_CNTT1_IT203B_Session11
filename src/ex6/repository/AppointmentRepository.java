package ex6.repository;

import ex6.DatabaseConnection;
import ex6.entity.Appointment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AppointmentRepository {

    public boolean addAppointment(Appointment appointment) {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = DatabaseConnection.getConnection();

            String sql = "insert into appointments(patient_name, appointment_date, doctor_name, status) values (?, ?, ?, ?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1, appointment.getPatientName());
            ps.setDate(2, appointment.getAppointmentDate());
            ps.setString(3, appointment.getDoctorName());
            ps.setString(4, appointment.getStatus());

            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            System.out.println("loi them lich kham: " + e.getMessage());
            return false;
        } finally {
            DatabaseConnection.closeAll(conn, ps, null);
        }
    }

    public boolean updateAppointment(Appointment appointment) {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = DatabaseConnection.getConnection();

            String sql = "update appointments set patient_name = ?, appointment_date = ?, doctor_name = ?, status = ? where id = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, appointment.getPatientName());
            ps.setDate(2, appointment.getAppointmentDate());
            ps.setString(3, appointment.getDoctorName());
            ps.setString(4, appointment.getStatus());
            ps.setInt(5, appointment.getId());

            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            System.out.println("loi cap nhat lich kham: " + e.getMessage());
            return false;
        } finally {
            DatabaseConnection.closeAll(conn, ps, null);
        }
    }

    public boolean deleteAppointment(int id) {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = DatabaseConnection.getConnection();

            String sql = "delete from appointments where id = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);

            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            System.out.println("loi xoa lich kham: " + e.getMessage());
            return false;
        } finally {
            DatabaseConnection.closeAll(conn, ps, null);
        }
    }

    public Appointment getAppointmentById(int id) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = DatabaseConnection.getConnection();

            String sql = "select id, patient_name, appointment_date, doctor_name, status from appointments where id = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);

            rs = ps.executeQuery();

            if (rs.next()) {
                Appointment appointment = new Appointment();
                appointment.setId(rs.getInt("id"));
                appointment.setPatientName(rs.getString("patient_name"));
                appointment.setAppointmentDate(rs.getDate("appointment_date"));
                appointment.setDoctorName(rs.getString("doctor_name"));
                appointment.setStatus(rs.getString("status"));
                return appointment;
            }
        } catch (Exception e) {
            System.out.println("loi tim lich kham theo id: " + e.getMessage());
        } finally {
            DatabaseConnection.closeAll(conn, ps, rs);
        }

        return null;
    }

    public List<Appointment> getAllAppointments() {
        List<Appointment> appointments = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = DatabaseConnection.getConnection();

            String sql = "select id, patient_name, appointment_date, doctor_name, status from appointments";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Appointment appointment = new Appointment();
                appointment.setId(rs.getInt("id"));
                appointment.setPatientName(rs.getString("patient_name"));
                appointment.setAppointmentDate(rs.getDate("appointment_date"));
                appointment.setDoctorName(rs.getString("doctor_name"));
                appointment.setStatus(rs.getString("status"));
                appointments.add(appointment);
            }
        } catch (Exception e) {
            System.out.println("loi lay danh sach lich kham: " + e.getMessage());
        } finally {
            DatabaseConnection.closeAll(conn, ps, rs);
        }

        return appointments;
    }
}