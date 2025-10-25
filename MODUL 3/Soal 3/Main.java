package Soal3;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int choose = 0;

        do {
            System.out.println(" ");
            System.out.println("Menu :");
            System.out.println("1. Tambah Mahasiswa");
            System.out.println("2. Hapus Mahasiswa berdasarkan NIM");
            System.out.println("3. Cari Mahasiswa berdasarkan NIM");
            System.out.println("4. Tampilkan Daftar Mahasiswa");
            System.out.println("0. Keluar");
            System.out.print("Pilihan : ");
            choose = input.nextInt();
            input.nextLine();

            switch (choose) {
                case 1:
                    System.out.print("Masukkan Nama Mahasiswa : ");
                    String name = input.nextLine();
                    System.out.print("Masukkan NIM Mahasiswa (harus unik) : ");
                    String nim = input.nextLine();
                    Student.addStudent(name, nim);
                    break;

                case 2:
                    System.out.print("Masukkan NIM Mahasiswa yang akan dihapus : ");
                    String deleteNim = input.nextLine();
                    Student.deleteStudent(deleteNim);
                    break;

                case 3:
                    System.out.print("Masukkan NIM Mahasiswa yang ingin dicari : ");
                    String searchId = input.nextLine();
                    Student.searchStudent(searchId);
                    break;

                case 4:
                    Student.displayAllStudents();
                    break;

                case 0:
                    System.out.print("Terima Kasih!");
                    break;
            }
        } while (choose != 0);

        input.close();
    }
}