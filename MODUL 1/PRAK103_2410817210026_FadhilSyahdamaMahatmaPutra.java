import java.util.Scanner;

public class PRAK103_2410817210026_FadhilSyahdamaMahatmaPutra {
    public static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
    Answer();

    }

    public static void Answer(){
        int i = input.nextInt();
        int number = input.nextInt();
        if(number % 2 != 0){
            do{
                System.out.print(number + " ");
                number += 2;
                i--;
            }while(i > 0);
        }

        else if (number % 2 == 0){
            number++;
            do {
                System.out.print(number + " ");
                number += 2;
                i--;
            } while(i > 0);
        }
    }
}