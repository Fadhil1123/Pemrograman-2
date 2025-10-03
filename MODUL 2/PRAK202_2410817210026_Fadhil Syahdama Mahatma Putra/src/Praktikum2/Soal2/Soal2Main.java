package Praktikum2.Soal2;

public class Soal2Main {
    public static void main(String[] args) {
        Coffe coffe1 = new Coffe();
        coffe1.coffeName = "Espresso";
        coffe1.size = "Medium";
        coffe1.price = 25000;

        coffe1.info();
        coffe1.setbuyer("Alice");
        System.out.println("Pembeli Kopi: " + coffe1.getbuyer());
        System.out.println("Pajak Kopi: Rp." + coffe1.gettax());
    }
}