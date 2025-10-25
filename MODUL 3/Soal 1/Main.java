package Soal1;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Dice dice = new Dice();

        int inputDice = scan.nextInt();

        dice.createDice(inputDice);
        dice.diceDisplay();

        scan.close();
    }
}