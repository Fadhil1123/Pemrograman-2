import java.util.Scanner;

public class PRAK102_2410817210026_FadhilSyahdamaMahatmaPutra {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = scanner.nextInt();

        Answer(number);
        scanner.close();
    }

    public static void Answer(int number) {
        int count = 0;
        while (count < 11) {
            int output;

            if (number % 5 == 0) {
                output = (number / 5) - 1;
            } else {
                output = number;
            }

            System.out.print(output + " ");

            number++;
            count++;
        }
    }
}