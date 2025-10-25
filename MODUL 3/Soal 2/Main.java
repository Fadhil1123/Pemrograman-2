package Soal2;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int number = input.nextInt();
        input.nextLine();

        for (int i = 0; i < number; i++) {
            String name = input.nextLine();

            String leadership = input.nextLine();

            String leader =  input.nextLine();

            if (leadership.equalsIgnoreCase("Monarki")) {
                Country.addCountry(new Country(name, leadership, leader));
            } else {
                int independenceDay = input.nextInt();

                int independenceMonth = input.nextInt();

                int independenceYear = input.nextInt();
                input.nextLine();

                Country.addCountry(new Country(name, leadership, leader, independenceDay, independenceMonth, independenceYear));
            }
        }

        Country.displayAllCountries();

        input.close();
    }
}