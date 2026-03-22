package ex5;

import ex5.Business.DoctorBusiness;
import ex5.entity.Doctor;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DoctorBusiness doctorBusiness = new DoctorBusiness();

        do {
            System.out.println("\n========= he thong quan ly benh vien rikkei-care =========");
            System.out.println("1. xem danh sach bac si");
            System.out.println("2. them bac si moi");
            System.out.println("3. thong ke chuyen khoa");
            System.out.println("4. thoat");
            System.out.print("chon chuc nang: ");

            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("vui long nhap so tu 1 den 4");
                continue;
            }

            switch (choice) {
                case 1:
                    List<Doctor> doctors = doctorBusiness.getAllDoctors();
                    if (doctors.isEmpty()) {
                        System.out.println("khong co du lieu bac si");
                    } else {
                        System.out.println("----- danh sach bac si -----");
                        for (Doctor doctor : doctors) {
                            System.out.println(doctor);
                        }
                    }
                    break;

                case 2:
                    try {
                        System.out.print("nhap ma bac si: ");
                        String doctorId = scanner.nextLine();

                        System.out.print("nhap ho ten: ");
                        String fullName = scanner.nextLine();

                        System.out.print("nhap chuyen khoa: ");
                        String speciality = scanner.nextLine();

                        Doctor newDoctor = new Doctor(doctorId, fullName, speciality);
                        boolean result = doctorBusiness.addDoctor(newDoctor);

                        if (result) {
                            System.out.println("them bac si thanh cong");
                        } else {
                            System.out.println("them bac si that bai");
                        }
                    } catch (Exception e) {
                        System.out.println("du lieu nhap khong hop le");
                    }
                    break;

                case 3:
                    List<String> statistics = doctorBusiness.statisticSpeciality();
                    if (statistics.isEmpty()) {
                        System.out.println("khong co du lieu thong ke");
                    } else {
                        System.out.println("----- thong ke chuyen khoa -----");
                        for (String item : statistics) {
                            System.out.println(item);
                        }
                    }
                    break;

                case 4:
                    System.out.println("thoat chuong trinh");
                    return;

                default:
                    System.out.println("lua chon khong hop le");
            }
        } while (true);
    }
}
