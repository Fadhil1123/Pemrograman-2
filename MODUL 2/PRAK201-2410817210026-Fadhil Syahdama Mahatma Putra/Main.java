public class Main {
    public static void main(String[] args) {
        Fruits apple = new Fruits();
        apple.setName("Apel");
        apple.setWeight(0.4);
        apple.setPrice(7000);
        apple.setTotalWeight(40);
        apple.print();

        Fruits mango = new Fruits();
        mango.setName("Mangga");
        mango.setWeight(0.2);
        mango.setPrice(3500);
        mango.setTotalWeight(15);
        mango.print();

        Fruits avocado = new Fruits();
        avocado.setName("Alpukat");
        avocado.setWeight(0.25);
        avocado.setPrice(10000);
        avocado.setTotalWeight(12);
        avocado.print();
    }
}
