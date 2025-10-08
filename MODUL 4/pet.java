package Soal1;

public class pet {
    private String name;
    private String race;

    public pet(String r, String n){
        this.race = r;
        this.name = n;
    }

    public void input1(){
        System.out.print("Nama Hewan Peliharaan: ");
    }

    public void input2(){
        System.out.print("Ras: ");
    }

    public void display(){
        System.out.println("Detail Hewan Peliharaan:");
        System.out.println("Nama hewan peliharaanku adalah : " + name);
        System.out.println("Dengan ras : " + race);
    }
}