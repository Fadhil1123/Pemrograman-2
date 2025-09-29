import java.util.Scanner;

public class PRAK105_2410817210026_FadhilSyahdamaMahatmaPutra {
    static float JariJari;
    static float Tinggi;
    static float volume;

    public static void main(String[] args) {
        TubeVolume();
        System.out.println("Volume tabung dengan jari-jari " + JariJari +
                "cm dan tinggi " + Tinggi +
                "cm adalah " + String.format("%.3f", volume) + " cm3");
    }

    public static void TubeVolume(){
        Scanner input = new Scanner(System.in);
        float phi = 3.14f;

        System.out.print("Masukkan Jari jari : ");
        JariJari = input.nextFloat();

        System.out.print("Masukkan Tinggi : ");
        Tinggi = input.nextFloat();

        volume = phi * JariJari * JariJari * Tinggi;
    }
}