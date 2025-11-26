package LoginSystem;

public class ApplicationRunner {
    private final ActionRegistry registry;
    private final ConsoleIO io;
    private final ActionFactory factory;

    public ApplicationRunner(ActionRegistry registry, ConsoleIO io, ActionFactory factory) {
        this.registry = registry;
        this.io = io;
        this.factory = factory;
    }

    public void start() {
        registry.register(1, factory.create(1));
        registry.register(2, factory.create(2));
        registry.register(3, factory.create(3));

        while (true) {
            io.showMenu(registry.getItems());
            int choice = io.readInt("Pilih menu: ");
            if (choice == 0) break;
            MenuAction a = registry.getAction(choice);
            if (a == null) io.error("Pilihan tidak valid");
            else a.execute();
        }
        io.info("Program selesai.");
        io.close();
    }
}
