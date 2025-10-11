package Soal2;

public class Pet {
    private String name;
    private String race;

    public Pet(String r, String n) {
        this.race = r;
        this.name = n;
    }

    public void display() {
        System.out.println("Detail Hewan Peliharaan:");
        System.out.println("Nama hewan peliharaanku adalah: " + this.name);
        System.out.println("Dengan ras: " + this.race);
    }
}
