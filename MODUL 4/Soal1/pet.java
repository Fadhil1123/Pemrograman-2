package Soal1;

public class pet {
    private String name;
    private String race;

    public pet(String r, String n){
        this.race = r;
        this.name = n;
    }

    public void display(){
        System.out.println("Detail Hewan Peliharaan:");
        System.out.println("Nama hewan peliharaanku adalah : " + name);
        System.out.println("Dengan ras : " + race);
    }
}
