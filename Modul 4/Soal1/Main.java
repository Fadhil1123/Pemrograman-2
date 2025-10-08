package Soal1;

import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        pet myPet = new pet("", "");

        myPet.input1();
        String name = scan.nextLine();

        myPet.input2();
        String petRace = scan.nextLine();

        myPet = new pet(petRace, name);

        myPet.display();
        scan.close();
    }
}