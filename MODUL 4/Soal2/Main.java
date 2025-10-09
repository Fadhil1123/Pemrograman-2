package Soal2;
import java.util.Scanner;

public class Main{
    public static Scanner scan = new Scanner(System.in);

    public static void main(String[] args){

        Cat myCat = new Cat();

        System.out.println("Pilih jenis hewan yang ingin diinputkan:");
        System.out.print("1 = Kucing\n");
        System.out.print("2 = Anjing\n");
        System.out.print("Masukkan pilihan: ");
        int choice = scan.nextInt();
        if(choice == 1){
            myCat.catInput();
            myCat.display();
            myCat.fur();
        } else if(choice == 2){

        }


    }
}