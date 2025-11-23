package LoginSystem;

public class RegistrationAction extends  BaseAction{
    private final AccountService service;

    public RegistrationAction(AccountService service, ConsoleIO io) {
        super("Registration", io);
        this.service = service;
    }



    @Override
    public void execute() {
        printHeader();
        String username = io.ask("Masukkan username: ");
        String password = io.ask("Masukkan password: ");
        try{
            service.register(username, password);
            io.info("Username " + username + " Berhasil ditambahkan");
        }catch(RuntimeException e){
            io.error(e.getMessage());
        }

        printComplete();
    }
}
