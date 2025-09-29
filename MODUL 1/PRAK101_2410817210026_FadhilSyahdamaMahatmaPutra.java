import java.util.Scanner;

public class PRAK101_2410817210026_FadhilSyahdamaMahatmaPutra {
    public static void main(String[] args) {
        Scanner Scanner = new Scanner(System.in);

        System.out.print("Masukkan Nama Lengkap : ");
        String Name = Scanner.nextLine();

        System.out.print("Masukkan Tempat Lahir : ");
        String Addres = Scanner.nextLine();

        System.out.print("Masukkan Tanggal Lahir : ");
        int Date = Scanner.nextInt();

        System.out.print("Masukkan Bulan Lahir : ");
        int Month = Scanner.nextInt();

        System.out.print("Masukkan Tahun Lahir : ");
        int Year = Scanner.nextInt();

        System.out.print("Masukkan Tinggi Badan : ");
        int height = Scanner.nextInt();

        System.out.print("Masukkan Berat Badan : ");
        Float Weight = Scanner.nextFloat();

        System.out.println("Nama Lengkap " + Name + ", Lahir di " + Addres + " pada Tanggal " + Date + " " + MonthName(Month) +  " " + Year);
        System.out.print("Tinggi Badan " + height + " cm dan Berat Badan " + Weight + "Kilogram" );

        Scanner.close();
    }

    public static String MonthName(int Month){
        switch(Month){
                case 1 : return "Januari";
                case 2 : return "Februari";
                case 3 : return  "Maret";
                case 4 : return  "April";
                case 5 : return  "Mei";
                case 6 : return  "Juni";
                case 7 : return  "Juli";
                case 8 : return  "Agustus";
                case 9 : return  "September";
                case 10 : return  "Oktober";
                case 11 : return  "November";
                case 12 : return  "Desember";
        }

        return "";
    };

}