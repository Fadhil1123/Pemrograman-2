package PRAK202_2410817210026_FadhilSyahdamaMahatmaPutra;

public class Soal2Main {
    public static void main(String[] args) {
        Kopi kopi1 = new Kopi();
        kopi1.namaKopi = "Espresso";
        kopi1.ukuran = "Medium";
        kopi1.harga = 25000;

        kopi1.info();
        kopi1.setpembeli("Alice");
        System.out.println("Pembeli Kopi: " + kopi1.getpembeli());
        System.out.println("Pajak Kopi: Rp." +kopi1.getpajak());
    }
}