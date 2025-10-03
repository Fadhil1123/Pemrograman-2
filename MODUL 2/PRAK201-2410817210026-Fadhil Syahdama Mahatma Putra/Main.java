//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Fruits apple   = new Fruits("Apel",   0.4, 7000, 40);
        Fruits mango   = new Fruits("Mangga", 0.2, 3500, 15);
        Fruits avocado = new Fruits("Alpukat",0.25, 10000,12);

        apple.print();
        mango.print();
        avocado.print();
    }
}