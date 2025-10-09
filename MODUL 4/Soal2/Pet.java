package Soal2;
public class Pet {
    String name;
    String race;

    public Pet(){}

    public void pet(String r, String n){
        this.race = r;
        this.name = n;
    }

    public void display(){
        System.out.println("Detail Hewan Peliharaan:");
        System.out.println("Nama hewan peliharaanku adalah: "+name);
        System.out.println("Dengan ras: "+race);
    }
}