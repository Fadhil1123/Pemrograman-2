package LoginSystem;

public class Main {
    public static void main(String[] args) {
        var io = new ConsoleIO();
        var repo = new AccountRepository();
        var registry = new ActionRegistry();
        AccountServiceImpl service = new AccountServiceImpl(repo);

        registry.register(1, new RegistrationAction(service, io));
        registry.register(2, new LoginAction(service, io));
        registry.register(3, new ListUserAction(service, io));

        ApplicationRunner runner = new ApplicationRunner(registry, io);
        runner.start();
    }
}