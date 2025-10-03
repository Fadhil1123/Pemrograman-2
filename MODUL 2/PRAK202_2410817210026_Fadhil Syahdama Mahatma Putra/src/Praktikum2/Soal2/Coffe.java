package Praktikum2.Soal2;

public class Coffe {
    public String coffeName;
    public String size;
    public double price;
    private String buyer;

    public void info() {
        System.out.println("Nama Kopi : " + coffeName);
        System.out.println("Ukuran    : " + size);
        System.out.println("Harga     : Rp." + String.format("%.0f", price));
    }

    public void setbuyer(String buyer) {
        this.buyer = buyer;
    }

    public String getbuyer(){
        return buyer;
    }

    public double gettax(){
        return price * 0.11;
    }
}