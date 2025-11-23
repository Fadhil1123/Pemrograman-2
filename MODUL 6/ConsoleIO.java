package LoginSystem;
import java.util.Map;
import java.util.Scanner;

public class ConsoleIO{
    private final Scanner scan = new Scanner(System.in);

    public String ask(String prompt){
        System.out.print(prompt);
        return scan.nextLine().trim();
    }

    public int readInt(String prompt){
        while(true){
            try{
                return Integer.parseInt(ask(prompt));
            }catch (NumberFormatException e){
                error("Input yang dimasukkan harus angka");
            }
        }
    }

    public void info(String msg){
        System.out.println(msg);
    }

    public void header(String title){
        System.out.println("=====" + title + "=====");
    }

    public void completeInfo(String title){
        System.out.println("=====" + title + " Selesai=====\n");
    }

    public void error(String msg){
        System.err.println(msg);
    }


    public void showMenu(Map<Integer, String> items){
        System.out.println("===== MENU =====");
        items.forEach((k,v)->System.out.println(k + ". " + v));
        System.out.println("0. Keluar");
    }

    public void close(){
        scan.close();
    }

}
