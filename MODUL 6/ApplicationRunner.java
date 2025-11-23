package LoginSystem;

public class ApplicationRunner {
    private final ActionRegistry registry;
    private final ConsoleIO io;

    public ApplicationRunner(ActionRegistry registry, ConsoleIO io) {
        this.registry = registry;
        this.io = io;
    }

    public void start(){
        while(true){
            io.showMenu(registry.getItems());
            int choice = io.readInt("Pilih menu : ");
            if(choice == 0){
                io.close();
                break;
            }
            MenuAction action = registry.getAction(choice);
            if(action != null){
                action.execute();
            } else {
                io.info("Input yang dimasukkan tidak valid");
            }
        }
        io.info("Program selesai");
    }
}
