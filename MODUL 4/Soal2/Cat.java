package Soal2;
public class Cat extends Pet {
    private String furColor;

    public Cat(String r, String n, String w) {
        super(r, n);
        this.furColor = w;
    }

    public void displayCatDetail() {
        super.display();
        System.out.print("Warna bulu: " +  furColor);
    }
}
