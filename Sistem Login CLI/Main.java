package LoginSystem;
import java.util.Scanner;

public class Main implements InputHandler {
    private Scanner scan = new Scanner(System.in);

    @Override
    public String ask(String text) {
        System.out.print(text);
        return scan.nextLine();
    }

    @Override
    public String show(String message) {
        System.out.println(message);
        return message;
    }

    public static void main(String[] args) {
        InputHandler handler = new Main();
        SystemController controller = new SystemController(handler);
        controller.start();
    }
}