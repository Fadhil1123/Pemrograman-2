package Soal2;
public class Cat extends Pet{
    String furColor;

    public Cat() {}


    public void catInput(){
        String Void = Main.scan.nextLine();
        System.out.print("Nama hewan peliharaan: ");
        name = Main.scan.nextLine();
        System.out.print("Ras: ");
        race = Main.scan.nextLine();
        System.out.print("Warna Bulu: ");
        furColor = Main.scan.nextLine();
    }

    public void cat(String r, String n, String w){
        this.race = r;
        this.name = n;
        this.furColor = w;
    }

    public void fur(){
        System.out.print("Warna Bulu: " + furColor);
    }
//    public void displayCatDetail(){
//        System.out.println(cat());
//    }
}
