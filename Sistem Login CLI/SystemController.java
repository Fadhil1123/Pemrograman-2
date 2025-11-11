package LoginSystem;
import java.util.HashMap;
import java.util.Scanner;

public class SystemController {
    private InputHandler handler;
    private AccountList accountList;
    private HashMap<Integer, MenuAction> actions = new HashMap<>();

    public SystemController(InputHandler handler) {
        this.handler = handler;
        this.accountList = new AccountList();
        registerActions();
    }

    private void registerActions() {
        actions.put(1, new Regist());
        actions.put(2, new Login());
        actions.put(3, new ListUser());
    }

    public void start() {
        Scanner scan = new Scanner(System.in);
        int choice = -1;

        while (true) {
            System.out.println("\n===== MENU =====");
            for (Integer key : actions.keySet()) {
                System.out.println(key + ". " + actions.get(key).getActionName());
            }
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");

            try {
                choice = Integer.parseInt(scan.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Input tidak valid.");
                continue;
            }

            if (choice == 0) {
                System.out.println("Program selesai.");
                break;
            }

            MenuAction action = actions.get(choice);
            if (action != null) {
                action.execute(accountList, handler);
            } else {
                System.out.println("Menu tidak valid.");
            }
            System.out.println("====" + action.getActionName() + " Selesai ====");
        }
    }
}
