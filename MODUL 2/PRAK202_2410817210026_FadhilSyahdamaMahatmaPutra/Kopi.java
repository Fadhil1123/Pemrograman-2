package PRAK202_2410817210026_FadhilSyahdamaMahatmaPutra;
public class Kopi {
    public String namaKopi;
    public String ukuran;
    public double harga;
    private String pembeli;

    public void info() {
        System.out.println("Nama Kopi : " + namaKopi);
        System.out.println("Ukuran    : " + ukuran);
        System.out.println("Harga     : Rp." + String.format("%.0f",harga));
    }

    public void setpembeli(String pembeli) {
        this.pembeli = pembeli;
    }

    public String getpembeli(){
        return pembeli;
    }

    public double getpajak(){
        return harga * 0.11;
    }
}