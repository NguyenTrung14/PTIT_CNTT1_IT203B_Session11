package ex5.Business;

import ex5.Dao.DoctorDao;
import ex5.entity.Doctor;

import java.util.List;

public class DoctorBusiness {
    private DoctorDao doctorDao;

    public DoctorBusiness() {
        doctorDao = new DoctorDao();
    }

    public List<Doctor> getAllDoctors() {
        return doctorDao.findAll();
    }

    public boolean addDoctor(Doctor doctor) {
        if (doctor.getDoctorId() == null || doctor.getDoctorId().trim().isEmpty()) {
            System.out.println("ma bac si khong duoc de trong");
            return false;
        }

        if (doctor.getFullName() == null || doctor.getFullName().trim().isEmpty()) {
            System.out.println("ho ten khong duoc de trong");
            return false;
        }

        if (doctor.getSpeciality() == null || doctor.getSpeciality().trim().isEmpty()) {
            System.out.println("chuyen khoa khong duoc de trong");
            return false;
        }

        if (doctor.getDoctorId().length() > 20) {
            System.out.println("ma bac si qua dai");
            return false;
        }

        if (doctor.getFullName().length() > 100) {
            System.out.println("ho ten qua dai");
            return false;
        }

        if (doctor.getSpeciality().length() > 50) {
            System.out.println("chuyen khoa qua dai");
            return false;
        }

        return doctorDao.insertDoctor(doctor);
    }

    public List<String> statisticSpeciality() {
        return doctorDao.countBySpeciality();
    }
}
