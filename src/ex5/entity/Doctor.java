package ex5.entity;

public class Doctor {
    private String doctorId;
    private String fullName;
    private String speciality;

    public Doctor() {
    }

    public Doctor(String doctorId, String fullName, String speciality) {
        this.doctorId = doctorId;
        this.fullName = fullName;
        this.speciality = speciality;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    @Override
    public String toString() {
        return "ma so: " + doctorId +
                " | ho ten: " + fullName +
                " | chuyen khoa: " + speciality;
    }
}