package Soal2;
import java.util.Scanner;

public class Main{
    public static Scanner scan = new Scanner(System.in);

    public static void main(String[] args){

        System.out.println("Pilih jenis hewan yang ingin diinputkan:");
        System.out.print("1 = Kucing\n");
        System.out.print("2 = Anjing\n");
        System.out.print("Masukkan pilihan: ");
        int choice = scan.nextInt();

        if(choice == 1){
            catData();
        } else if(choice == 2){
            dogData();
        }
    }

    static private void catData(){
        Main.scan.nextLine();
        System.out.print("Nama hewan peliharaan: ");
        String name = scan.nextLine();
        System.out.print("Ras: ");
        String race = scan.nextLine();
        System.out.print("Warna Bulu: ");
        String furColor = scan.nextLine();

        Cat cat = new Cat(race, name, furColor);
        cat.displayCatDetail();
    }

    static private void dogData(){
        Main.scan.nextLine();
        System.out.print("Nama hewan peliharaan: ");
        String name = scan.nextLine();
        System.out.print("Ras: ");
        String race = scan.nextLine();
        System.out.print("Warna Bulu: ");
        String furColor = scan.nextLine();
        System.out.print("Kemampuan: ");
        String skill  = scan.nextLine();

        Dog dog = new Dog(name, race, furColor, skill);
        dog.displayDogDetail();
    }
}
