package ex6;

import ex6.entity.Appointment;
import ex6.repository.AppointmentRepository;

import java.sql.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        AppointmentRepository repository = new AppointmentRepository();

        System.out.println("===== danh sach lich kham ban dau =====");
        List<Appointment> list1 = repository.getAllAppointments();
        for (Appointment appointment : list1) {
            System.out.println(appointment);
        }

        System.out.println("\n===== them lich kham moi =====");
        Appointment newAppointment = new Appointment(
                "pham thi d",
                Date.valueOf("2026-03-25"),
                "dr. dung",
                "cho kham");
        boolean addResult = repository.addAppointment(newAppointment);
        System.out.println("them moi: " + addResult);

        System.out.println("\n===== danh sach sau khi them =====");
        List<Appointment> list2 = repository.getAllAppointments();
        for (Appointment appointment : list2) {
            System.out.println(appointment);
        }

        System.out.println("\n===== tim lich kham theo id = 1 =====");
        Appointment appointmentById = repository.getAppointmentById(1);
        System.out.println(appointmentById);

        System.out.println("\n===== cap nhat lich kham id = 1 =====");
        Appointment updateAppointment = new Appointment(
                1,
                "nguyen van a",
                Date.valueOf("2026-03-30"),
                "dr. an",
                "da doi lich");
        boolean updateResult = repository.updateAppointment(updateAppointment);
        System.out.println("cap nhat: " + updateResult);

        System.out.println("\n===== xem lai lich kham id = 1 =====");
        System.out.println(repository.getAppointmentById(1));

        System.out.println("\n===== xoa lich kham id = 2 =====");
        boolean deleteResult = repository.deleteAppointment(2);
        System.out.println("xoa: " + deleteResult);

        System.out.println("\n===== danh sach cuoi cung =====");
        List<Appointment> list3 = repository.getAllAppointments();
        for (Appointment appointment : list3) {
            System.out.println(appointment);
        }
    }
}