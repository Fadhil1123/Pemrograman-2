import java.util.Scanner;

public class PRAK104_2410817210026_FadhilSyahdamaMahatmaPutra {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Tangan Abu : ");
        String[] abuChoices = scanner.nextLine().toUpperCase().split(" ");
        System.out.print("Tangan Bagas : ");
        String[] bagasChoices = scanner.nextLine().toUpperCase().split(" ");

        String winner = Winner(abuChoices, bagasChoices);
        System.out.println(winner);

        scanner.close();
    }

    public static String Winner(String[] abuChoices, String[] bagasChoices) {
        int scoreAbu = 0;
        int scoreBagas = 0;

        for (int i = 0; i < 3; i++) {
            char abu = abuChoices[i].charAt(0);
            char bagas = bagasChoices[i].charAt(0);

            if (abu == bagas) {
            } else if ((abu == 'B' && bagas == 'G') ||
                    (abu == 'G' && bagas == 'K') ||
                    (abu == 'K' && bagas == 'B')) {
                scoreAbu++;
            } else {
                scoreBagas++;
            }
        }

        if (scoreAbu > scoreBagas) {
            return "Abu";
        } else if (scoreBagas > scoreAbu) {
            return "Bagas";
        } else {
            return "Seri";
        }
    }
}