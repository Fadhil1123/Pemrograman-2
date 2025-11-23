package LoginSystem;

public class LoginAction extends BaseAction{
    private final AccountService service;

    protected LoginAction(AccountService service, ConsoleIO io) {
        super("Login", io);
        this.service = service;
    }

    @Override
    public void execute() {
        printHeader();
        String username = io.ask("Masukkan username: ");
        String password = io.ask("Masukkan password: ");
        var account = service.authenticate(username, password);
        if(account == null){
            io.info("Username atau password yang dimasukkan salah");
        } else {
            io.info("Selamat datang " + username);
        }
        printComplete();
    }
}
