package LoginSystem;

public class Main {
    public static void main(String[] args) {
        ConsoleIO io = new ConsoleIO();
        AccountRepository repo = new AccountRepositoryImpl();
        AccountService service = new AccountServiceImpl(repo);
        AccountFacade facade = new AccountFacade(service, io);

        ActionFactory factory = new ActionFactory.Default(facade, io);

        ActionRegistry registry = new ActionRegistry();
        ApplicationRunner runner = new ApplicationRunner(registry, io, factory);

        runner.start();
    }
}
