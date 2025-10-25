package Soal2;

import java.util.*;

public class Country {
    private String name;
    private String leadership;
    private String leader;
    private int independenceDay;
    private int independenceMonth;
    private int independenceYear;

    private static LinkedList<Country> countries = new LinkedList<>();

    private static HashMap<Integer, String> monthName = new HashMap<>();

    static {
        monthName.put(1, "Januari");
        monthName.put(2, "Februari");
        monthName.put(3, "Maret");
        monthName.put(4, "April");
        monthName.put(5, "Mei");
        monthName.put(6, "Juni");
        monthName.put(7, "Juli");
        monthName.put(8, "Agustus");
        monthName.put(9, "September");
        monthName.put(10, "Oktober");
        monthName.put(11, "November");
        monthName.put(12, "Desember");
    }

    public Country(String name, String leadership, String leader, int independenceDay, int independenceMonth, int independenceYear) {
        this.name = name;
        this.leadership = leadership;
        this.leader = leader;
        this.independenceDay = independenceDay;
        this.independenceMonth = independenceMonth;
        this.independenceYear = independenceYear;
    }

    public Country(String name, String leadership, String leader) {
        this.name = name;
        this.leadership = leadership;
        this.leader = leader;
    }

    public String getLeadership() {return leadership;}

    public int getIndependenceMonth() {return independenceMonth;}

    public static void addCountry(Country country) {countries.add(country);}

    public static void displayAllCountries() {
        for (Country c : countries) {
            if (c.getLeadership().equalsIgnoreCase("Monarki")) {
                c.info("");
            } else {
                String month = monthName.get(c.getIndependenceMonth());
                c.info(month);
            }
        }
    }

    public void info(String monthName) {
        if (leadership.equalsIgnoreCase("Monarki")) {
            System.out.println("Negara " + name + " mempunyai Raja bernama " + leader);
        } else {
            System.out.println("Negara " + name + " mempunyai " + leadership + " bernama " + leader);
            System.out.println("Deklarasi Kemerdekaan pada Tanggal " + independenceDay + " " + monthName + " " + independenceYear);
        }
        System.out.println();
    }
}