package Soal1;
import java.util.LinkedList;
import java.util.Random;

public class Dice {
    private LinkedList<DiceItem> diceList;

    public Dice() {
        diceList = new LinkedList<DiceItem>();
    }

    public void createDice(int input) {
        for (int i = 0; i < input; i++) {
            DiceItem dice = new DiceItem();
            diceList.add(dice);
        }
    }

    public void diceDisplay() {
        for (int i = 0; i < diceList.size(); i++) {
            int value = diceList.get(i).getNumber();
            System.out.println("Dadu ke-" + (i + 1) + " bernilai " + value);
        }
        System.out.println("Total nilai dadu keseluruhan " + totalDice());
    }

    public int totalDice() {
        int total = 0;
        for (int i = 0; i < diceList.size(); i++) {
            total += diceList.get(i).getNumber();
        }
        return total;
    }

    private class DiceItem {
        private int number;

        public DiceItem() {randomDice();}

        private void randomDice() {
            Random rand = new Random();
            this.number = rand.nextInt(6) + 1;
        }

        public int getNumber() {return this.number;}
    }
}