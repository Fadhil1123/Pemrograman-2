package Soal1;
import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        System.out.print("Nama: ");
        String name = scan.nextLine();

        System.out.print("Ras: ");
        String race = scan.nextLine();

        pet myPet = new pet(race, name);
        myPet.display();
        scan.close();
    }
}
