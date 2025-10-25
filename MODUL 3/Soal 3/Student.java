package Soal3;
import java.util.*;

public class Student {
    private String name;
    private String id;
    private static ArrayList<Student> students = new ArrayList<>();

    public Student(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public static void addStudent(String name, String nim) {
            students.add(new Student(name, nim));
            System.out.println("Mahasiswa " + name + " ditambahkan");
    }

    public static void deleteStudent(String nim) {
        boolean found = false;
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId().equals(nim)) {
                students.remove(i);
                System.out.println("Mahasiswa dengan NIM " + nim + " telah dihapus");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("NIM tidak ditemukan");
        }
    }

    public static void searchStudent(String nim) {
        boolean found = false;
        for (Student s : students) {
            if (s.getId().equals(nim)) {
                System.out.println("Data Mahasiswa ditemukan");
                System.out.println("Nama : " + s.getName());
                System.out.println("NIM : " + s.getId());
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("NIM tersebut tidak ditemukan");
        }
    }

    public static void displayAllStudents() {
        System.out.println("Daftar Mahasiswa");
        if (students.isEmpty()) {
            System.out.println("Belum ada data Mahasiswa");
        } else {
            for (Student s : students) {
                System.out.println("NIM : " + s.getId() + ", Nama : " + s.getName());
            }
        }
    }
}